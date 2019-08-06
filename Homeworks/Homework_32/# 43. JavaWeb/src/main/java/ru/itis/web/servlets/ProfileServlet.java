package ru.itis.web.servlets;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ProfileServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookies[] = request.getCookies();
        boolean isAuthorized = false;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("name")) {
                    PrintWriter writer = null;
                    try {
                        writer = response.getWriter();
                    } catch (IOException e) {
                        throw new IllegalStateException(e);
                    }
                    writer.println("<!DOCTYPE html>\n" +
                            "<html>\n" +
                            "<head>\n" +
                            "  <title>Users</title>\n" +
                            "</head>\n" +
                            "<body>\n" +
                            "Hello, " + cookie.getValue() + "\n" +
                            "<a href=\"/web_example_war/users\">Show Users</a>" + "\n" +
                            "</body>\n" +
                            "</html>");
                    isAuthorized = true;
                }
            }
        }
        if (!isAuthorized){
            try {
                response.sendRedirect("/web_example_war/signIn");
            } catch (IOException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }
}
