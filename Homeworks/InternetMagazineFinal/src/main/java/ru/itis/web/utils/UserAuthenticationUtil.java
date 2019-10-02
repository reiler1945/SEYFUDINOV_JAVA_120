package ru.itis.web.utils;

import org.springframework.stereotype.Component;
import ru.itis.web.dto.UserDto;
import ru.itis.web.models.User;
import ru.itis.web.security.details.UserDetailsImpl;

import static ru.itis.web.dto.UserDto.from;

@Component
public class UserAuthenticationUtil {
    public UserDto getUserByUserDetails(UserDetailsImpl userDetails) {
        User user = userDetails.getUser();
        return from(user);
    }
}
