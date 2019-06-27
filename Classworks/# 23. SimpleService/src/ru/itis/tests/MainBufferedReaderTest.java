package ru.itis.tests;

import ru.itis.repositories.UsersRepository;
import ru.itis.models.*;

public class MainBufferedReaderTest {
    public static void main(String[] args) {
        UsersRepository usersRepository = new UsersRepository("users.txt", null);
        User[] users = usersRepository.findAll();
        int i = 0;
        while (users[i] != null) {
            System.out.println(users[i]);
            i++;
        }
    }
}
