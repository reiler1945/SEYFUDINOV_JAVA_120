package ru.itis.service.app;

import ru.itis.service.models.User;
import ru.itis.service.models.UserRole;
import ru.itis.service.repositories.CrudRepository;
import ru.itis.service.repositories.UsersRepository;
import ru.itis.service.exceptions.*;
import ru.itis.service.repositories.UsersRepositoryFileBasedImpl;
import java.util.*;

import java.util.List;
import java.util.Optional;

public class MainUsersRepositoryFileBasedImpl {
    private static void printUserList(CrudRepository<User> crudRepository) {
        // выводим в цикле
        List<User> usersAll = crudRepository.findAll();
        for (User us : usersAll) {
            System.out.println(us);
        }
        System.out.println("\n");
    }


    public static void main(String[] args) {
        UsersRepository usersRepository = new UsersRepositoryFileBasedImpl("users.txt");
        printUserList(usersRepository);

        Optional<User> userOptional = usersRepository.findOneById(1L);
        System.out.println("пытаемся создать существующего пользователя с id = 1:");
        try {
            if (userOptional.isPresent()) {
                User savedUser = usersRepository.save(userOptional.get());
            }
        } catch (UserExistsInFileRepositoryException e) {
            System.err.println(e.getMessage());
        }

        printUserList(usersRepository);

        System.out.println("пытаемся создать нового пользователя: ");
        User newUser = User.builder()
                .login("Vasya")
                .password("123456")
                .role(UserRole.ADMIN)
                .build();
        Optional<User> optionalUserByLogin = usersRepository.findOneByLogin(newUser.getLogin());
        if (optionalUserByLogin.isPresent()) {
            System.out.println("Пользователь  с логином " + newUser.getLogin() + " уже существует!");
            newUser.setId(optionalUserByLogin.get().getId());
        } else {
            newUser = usersRepository.save(newUser);
            System.out.println("savedUser.id = " + newUser.getId());
            System.out.println(newUser);
        }

        printUserList(usersRepository);

        System.out.println("проапдейтим новый объект: ");

        // проапдейтим новый объект
        newUser.setFirstName("Вася");
        newUser.setPassword("654321");
        usersRepository.update(newUser);
        System.out.println(newUser);

        printUserList(usersRepository);

        System.out.println("удалим новый объект: ");

        // удалим новый объект
        usersRepository.delete(newUser.getId());

        printUserList(usersRepository);

        HashMap<String, Integer> map = new HashMap<>();
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        map.put("4", 4);
        List<Integer> list = new ArrayList<>(map.values());
    }
}
