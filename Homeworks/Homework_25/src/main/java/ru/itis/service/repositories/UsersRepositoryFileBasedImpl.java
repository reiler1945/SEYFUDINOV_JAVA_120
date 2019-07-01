package ru.itis.service.repositories;

import ru.itis.service.exceptions.UserExistsInFileRepositoryException;
import ru.itis.service.models.User;
import ru.itis.service.models.UserRole;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class UsersRepositoryFileBasedImpl implements UsersRepository {

    private String fileName;
    private static final String separator = "|";

    private StringsRowMapper<User> userRowMapper = line -> {
        String[] userData = line.split("\\" + separator);
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
                .id(Long.parseLong(idString))
                .login(login)
                .password(password)
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
    };

    private ModelToStringsRow<User> modelToStringsRow = user -> {
        if (user.isPresent()) {
            return user.get().getId() + separator
                    + user.get().getFirstName() + separator
                    + user.get().getLastName() + separator
                    + user.get().getAge() + separator
                    + user.get().getEmail() + separator
                    + user.get().getPhone() + separator
                    + user.get().getLogin() + separator
                    + user.get().getPassword() + separator
                    + user.get().getRole().toString();
        }
        return null;
    };

    public UsersRepositoryFileBasedImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Optional<User> findOneByLogin(String login) {
        try {
            Reader reader = new FileReader(fileName);
            BufferedReader bufferedReader
                    = new BufferedReader(reader);

            String currentUserLine = bufferedReader.readLine();
            while (currentUserLine != null) {
                User user = userRowMapper.mapRow(currentUserLine);

                if (user.getLogin().equals(login)) {
                    return Optional.of(user);
                }

                currentUserLine = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }

        return Optional.empty();
    }

    @Override
    public Optional<User> findOneById(Long id) {
        try {
            Reader reader = new FileReader(fileName);
            BufferedReader bufferedReader
                    = new BufferedReader(reader);

            String currentUserLine = bufferedReader.readLine();
            while (currentUserLine != null) {
                User user = userRowMapper.mapRow(currentUserLine);

                if (user.getId().equals(id)) {
                    return Optional.of(user);
                }

                currentUserLine = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }

        return Optional.empty();
    }

    @Override
    public User save(User model) {
        if (model == null) {
            throw new IllegalArgumentException("Нельзя сохранить пустой объект");
        }

        // проверяем на наличие в репозитории
        List<User> userAll = this.findAll();
        Predicate<User> predicate = user -> (user.getLogin().equals(model.getLogin()));
        List<User> filterUser = ModelUtils.getFirst(userAll, predicate);

        // если есть уже
        if (filterUser.size() > 0) {
            throw new UserExistsInFileRepositoryException("Такой юзер уже есть!");
        }

        if (model.getId() == null) {
            model.setId(new IdGenerator("userId.txt").generate());
        }

        try {
            Writer fileWriter = new FileWriter(fileName, true);
            String userLine = modelToStringsRow.toStringRow(Optional.of(model)) + "\n";
            fileWriter.write(userLine);
            fileWriter.close();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        return model;
    }

    @Override
    public void update(User model) {
        List<User> allUser = findAll();
        Predicate<User> predicate = user -> user.getId() == model.getId();
        allUser.removeIf(predicate);
        allUser.add(model);
        rewriteUserRepository(allUser);
    }

    @Override
    public void delete(Long id) {
        List<User> allUser = findAll();
        Predicate<User> predicate = user -> user.getId() == id;
        allUser.removeIf(predicate);
        rewriteUserRepository(allUser);
    }

    private void rewriteUserRepository(List<User> listUser) {
        try {
            Writer fileWriter = new FileWriter(fileName, false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (User user: listUser) {
                String userLine = modelToStringsRow.toStringRow(Optional.of(user)) + "\n";
                bufferedWriter.write(userLine);
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public List<User> findAll() {
        List<User> result = new ArrayList<>();
        try {
            Reader reader = new FileReader(fileName);
            BufferedReader bufferedReader
                    = new BufferedReader(reader);

            String currentUserLine = bufferedReader.readLine();
            while (currentUserLine != null) {
                User user = userRowMapper.mapRow(currentUserLine);
                result.add(user);
                currentUserLine = bufferedReader.readLine();
            }
            // вопрос
            bufferedReader.close();
            reader.close();
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
        return result;
    }
}
