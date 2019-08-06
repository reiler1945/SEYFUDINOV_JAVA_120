package ru.itis.web.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.itis.web.models.User;
import ru.itis.web.models.UserRole;
import ru.itis.web.repositories.UsersRepository;
import ru.itis.web.services.UsersService;

import javax.servlet.ServletContext;

public class JdbcTemplateTestMain {
    public static void main(String[] args) {
        User newUser = User.builder().firstName("Petya")
                .lastName("Sidorov")
                .login("petun")
                .age(33)
                .role(UserRole.MODERATOR)
                .build();
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/context.xml");
        UsersRepository usersRepository = applicationContext.getBean(UsersRepository.class);

        System.out.println("Age = " + newUser.getAge());
        usersRepository.save(newUser);

        newUser.setPhone("9170123456");
        newUser.setEmail("petun@mail.ru");

        usersRepository.update(newUser);

        usersRepository.delete(newUser.getId());
    }
}
