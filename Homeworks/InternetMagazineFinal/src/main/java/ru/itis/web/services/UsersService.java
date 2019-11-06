package ru.itis.web.services;

import ru.itis.web.dto.SignInForm;
import ru.itis.web.dto.SignUpForm;
import ru.itis.web.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    void signUp(String uuid, SignUpForm form);
    Optional<String> signIn(SignInForm form);
    Optional<UserDto> getUserByCookie(String cookie);
    List<UserDto> getAllUsers();
    List<UserDto> getAllUsersByPage(int pageSize, int pageNum);
    Integer getCountUsers();
    void emailConfirm(String email);
    boolean isNotValidUUID(String uuid);
}
