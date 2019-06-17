package ru.itis.repositories;

import ru.itis.models.User;
import ru.itis.models.UserRole;

import java.io.*;

public class UsersRepository {
    private String fileName;
    private IdGenerator idGenerator;
    private static final String SEPARATOR = "\\|";

    public UsersRepository(String fileName, IdGenerator idGenerator) {
        this.fileName = fileName;
        this.idGenerator = idGenerator;
    }

    public void save(User user) {
        try {
            user.setId(idGenerator.generate());
            OutputStream outputStream = new FileOutputStream(fileName, true);
            String userLine = user.toString() + "\n";
            outputStream.write(userLine.getBytes());
            outputStream.close();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public User findOneById(long id) {
        User user = null;
        try {
            Reader reader = new FileReader("Users.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String currentUserLine = bufferedReader.readLine();
            String[] userData = null;
            long currentId;
            while (currentUserLine != null) {
                userData = currentUserLine.split(UsersRepository.SEPARATOR);
                currentId = Long.parseLong(userData[0]);
                if (currentId == id) {
                    user = this.userByDataArray(userData);
                    break;
                }
                currentUserLine = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
        return user;
    }

    public User[] findAll() {
        // Создаем массив для результата
        // сюда положим пользователей
        User[] users = new User[100];
        try {
            // открываем файл для чтения
            Reader reader = new FileReader(fileName);
            // открываем буфер для чтения из файла и передаем
            // туда файл
            BufferedReader bufferedReader
                    = new BufferedReader(reader);

            // считываем из файла первую строку
            String currentUserLine = bufferedReader.readLine();
            // начинаем с нуля
            int currentIndex = 0;
            // пока файл не кончился
            while (currentUserLine != null) {
                String[] userDataArray = currentUserLine.split(UsersRepository.SEPARATOR);
                User user = this.userByDataArray(userDataArray);
                users[currentIndex] = user;
                currentIndex++;
                currentUserLine = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }

        return users;
    }

    private User userByDataArray(String[] userData) {
        if (userData != null) {
            // разбиваем исходную строку
            // на элементы по разделителю "|"

            String idString = userData[0];
            String firstName = userData[1];
            String lastName = userData[2];
            String ageAsString = userData[3];
            String phone = userData[4];
            String email = userData[5];
            String login = userData[6];
            String password = userData[7];
            UserRole role = UserRole.valueOf(userData[8]);

            User user = User.builder()
                    .login(login)
                    .password(password)
                    .id(Long.parseLong(idString))
                    .build();

            if (!firstName.equals("null")) {
                user.setFirstName(firstName);
            }

            if (!lastName.equals("null")) {
                user.setLastName(lastName);
            }

            if (!ageAsString.equals("null")) {
                user.setAge(Integer.parseInt(ageAsString));
            }

            user.setRole(role);
            return user;
        } else {
            return null;
        }
    }
}
