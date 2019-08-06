package ru.itis.web.servlets;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ShowUsersServlet extends HttpServlet {
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "6181";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/Test";
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection =
                    DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from service_user;");
            PrintWriter writer = response.getWriter();
            writer.println("<!DOCTYPE html>\n" +
                    "<html>\n" +
                    " <head>\n" +
                    "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"" +
                    " </head>\n"
                    );
            writer.println("<body>");
            writer.println("<H1> Users: </H1>");
            writer.println("<table align=\"center\" border=\"1\">");
            writer.println("<tr>\n" +
                    "  <th>Id</th>\n" +
                    "  <th>First name</th>\n" +
                    "  <th>Last Name</th>\n" +
                    "  <th>age</th>\n" +
                    "  <th>phone</th>\n" +
                    "  <th>email</th>\n" +
                    "  <th>login</th>\n" +
                    "  <th>role</th>\n" +
                    "</tr>");
            while (resultSet.next()) {
                writer.println("<tr>");
                writer.println("<td>");
                writer.print(resultSet.getLong("id"));
                writer.println("</td>");
                writer.println("<td>");
                writer.print(resultSet.getString("first_name"));
                writer.println("</td>");
                writer.println("<td>");
                writer.print(resultSet.getString("last_name"));
                writer.println("</td>");
                writer.println("<td>");
                writer.print(resultSet.getString("age"));
                writer.println("</td>");
                writer.println("<td>");
                writer.print(resultSet.getString("phone"));
                writer.println("</td>");
                writer.println("<td>");
                writer.print(resultSet.getString("email"));
                writer.println("</td>");
                writer.println("<td>");
                writer.print(resultSet.getString("login"));
                writer.println("</td>");
                writer.println("<td>");
                writer.print(resultSet.getString("role"));
                writer.println("</td>");
                writer.println("</tr>");
            }
            writer.println("</table>");
            writer.println("</body>");
            writer.println("</html>");
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
