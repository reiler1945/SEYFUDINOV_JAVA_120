package ru.itis.web.services;

import freemarker.template.Template;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.web.dto.SignInForm;
import ru.itis.web.dto.SignUpForm;
import ru.itis.web.dto.UserDto;
import ru.itis.web.models.Cart;
import ru.itis.web.models.CookieValue;
import ru.itis.web.models.User;
import ru.itis.web.models.enums.UserRole;
import ru.itis.web.models.enums.UserState;
import ru.itis.web.repositories.CartsRepository;
import ru.itis.web.repositories.CookieValuesRepository;
import ru.itis.web.repositories.UsersRepository;

import java.io.StringWriter;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class UsersServiceImpl implements UsersService {

    private Logger logger = LoggerFactory.getLogger(UsersServiceImpl.class);

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private CookieValuesRepository cookieValuesRepository;

    @Autowired
    private CartsRepository cartsRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmailService emailService;

    @Value("${mail.confirm.subject}")
    private String subject;

    @Value("${server.url}")
    private String serverUrl;

    @Autowired
    private Template confirmMailTemplate;

    @Autowired
    private ExecutorService executorService;

    @Override
    @Transactional
    public void signUp(String uuid, SignUpForm form) {

        User user = usersRepository.findByConfirmUUID(uuid);

        user.setHashPassword(passwordEncoder.encode(form.getPassword()));
        user.setLogin(form.getLogin());
        user.setRole(UserRole.USER);
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setState(UserState.CONFIRMED);
        user.setConfirmUUID(null);

        usersRepository.save(user);
        Cart cart = Cart.builder().user(user).build();
        cartsRepository.save(cart);
    }

    @Override
    public Optional<String> signIn(SignInForm form) {
        Optional<User> userCandidate = usersRepository.findByLogin(form.getLogin());

        if (userCandidate.isPresent()) {
            User user = userCandidate.get();
            if (passwordEncoder.matches(form.getPassword(), user.getHashPassword())) {
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

    @SneakyThrows
    @Override
    public void emailConfirm(String email) {

        Optional<User> user = usersRepository.findByEmail(email);

        User newUser = user.orElseGet(() -> User.builder()
                .email(email)
                .build());

        newUser.setState(UserState.NOT_CONFIRMED);
        newUser.setConfirmUUID(UUID.randomUUID().toString());

        usersRepository.save(newUser);

        Runnable confirmMailTask = () -> {
            Map<String, Object> placeholders = new HashMap<>();
            placeholders.put("host", serverUrl);
            placeholders.put("id", newUser.getConfirmUUID());

            StringWriter stringWriter = new StringWriter();
            try {
                confirmMailTemplate.process(placeholders, stringWriter);

            } catch (Exception e) {
                throw new IllegalArgumentException(e);
            }
            String mailText = stringWriter.toString();

            logger.info("Send email to " + newUser.getEmail() + " by thread " + Thread.currentThread().getName());
            emailService.sendEmail(newUser.getEmail(), subject, mailText);

        };

        executorService.submit(confirmMailTask);
    }

    @Override
    public boolean isNotValidUUID(String uuid) {
        return !usersRepository.existsByConfirmUUID(uuid);
    }
}
