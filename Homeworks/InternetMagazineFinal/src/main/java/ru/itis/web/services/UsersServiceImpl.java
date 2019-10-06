package ru.itis.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.web.dto.SignInForm;
import ru.itis.web.dto.SignUpForm;
import ru.itis.web.dto.UserDto;
import ru.itis.web.models.Cart;
import ru.itis.web.models.CookieValue;
import ru.itis.web.models.User;
import ru.itis.web.models.UserRole;
import ru.itis.web.repositories.CartsRepository;
import ru.itis.web.repositories.CookieValuesRepository;
import ru.itis.web.repositories.UsersRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private CookieValuesRepository cookieValuesRepository;

    @Autowired
    private CartsRepository cartsRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void signUp(SignUpForm form) {
        User user = User.builder()
                .password(passwordEncoder.encode(form.getPassword()))
                .login(form.getLogin())
                .role(UserRole.USER)
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .build();
        user = usersRepository.save(user);
        Cart cart = Cart.builder().user(user).build();
        cartsRepository.save(cart);
    }

    @Override
    public Optional<String> signIn(SignInForm form) {
        Optional<User> userCandidate = usersRepository.findByLogin(form.getLogin());

        if (userCandidate.isPresent()) {
            User user = userCandidate.get();
            if (passwordEncoder.matches(form.getPassword(), user.getPassword())) {
                CookieValue cookieValue = CookieValue.builder()
                        .value(UUID.randomUUID().toString())
                        .user(user)
                        .build();
                cookieValuesRepository.save(cookieValue);
                return Optional.of(cookieValue.getValue());
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<UserDto> getUserByCookie(String cookie) {
        Optional<CookieValue> cookieValueCandidate = cookieValuesRepository.findByValue(cookie);
        if (cookieValueCandidate.isPresent()) {
            CookieValue cookieValue = cookieValueCandidate.get();
            User user = cookieValue.getUser();
            Long cartId = cartsRepository.findByUser_Id(user.getId()).get().getId();
            UserDto result = UserDto.builder()
                    .id(user.getId())
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .cartId(cartId)
                    .role(user.getRole().toString())
                    .build();

            return Optional.of(result);
        }
        return Optional.empty();
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = usersRepository.findAll();

        List<UserDto> result = new ArrayList<>();

        for (User user : users) {
            UserDto userDto = UserDto.builder()
                    .id(user.getId())
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .build();

            result.add(userDto);
        }
        return result;
    }

    @Override
    public List<UserDto> getAllUsersByPage(int pageSize, int pageNum) {
        List<User> users = usersRepository.findAllByPage(pageSize, pageNum);
        Stream<User> userStream = users.stream();
        Stream<UserDto> userDtoStream = userStream
                .map(user -> UserDto.builder()
                        .id(user.getId())
                        .firstName(user.getFirstName())
                        .lastName(user.getLastName())
                        .role(user.getRole().toString())
                        .build());
        return userDtoStream.collect(Collectors.toList());
    }

    @Override
    public Integer getCountUsers() {
        return usersRepository.getCountUsers();
    }
}
