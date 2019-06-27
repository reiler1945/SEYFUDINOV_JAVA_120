package ru.itis.repositories;

import ru.itis.models.User;
import ru.itis.models.UserRole;

import java.io.*;

public class UsersRepository {
    private String fileName;
    private IdGenerator idGenerator;

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

    public User[] findAll() {
        User users[] = new User[100];
        try {
            Reader reader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String currentUserLine = bufferedReader.readLine();
            int i = 0;
            while (currentUserLine != null) {
                String[] userLine = currentUserLine.split("\\|");
                users[i++] = User.builder()
                        .id(Integer.parseInt(userLine[0]))
                        .firstName(userLine[1])
                        .lastName(userLine[2])
                        .age(Integer.parseInt(userLine[3]))
                        .email(userLine[4])
                        .phone(userLine[5])
                        .login(userLine[6])
                        .password(userLine[7])
                        .role(UserRole.valueOf(userLine[8]))
                        .build();
                currentUserLine = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
        return users;
    }
}
