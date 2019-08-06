package ru.itis.web.listeners;

import lombok.SneakyThrows;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.itis.web.services.UsersService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ComponentsContainer implements ServletContextListener {

    @SneakyThrows
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        //String fullPath = context.getRealPath("/WEB-INF/context.xml");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/context.xml");
        sce.getServletContext().setAttribute("usersService", applicationContext.getBean(UsersService.class));
    }
}
