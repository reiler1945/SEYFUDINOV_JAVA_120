package ru.itis.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication. run(Application.class, args);
    }
}
