package ru.itis.tests;

import ru.itis.models.User;
import ru.itis.repositories.UsersRepository;

public class MainFindOneByIdTest {
    public static void main(String[] args) {
        UsersRepository userRepository = new UsersRepository("Users.txt", null);
        User user = userRepository.findOneById(2L);
        System.out.println(user);
    }
}
