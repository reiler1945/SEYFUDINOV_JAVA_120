package ru.itis.web.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import ru.itis.web.models.User;
import ru.itis.web.models.UserRole;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Component
public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {

    //language=SQL
    private final static String SQL_INSERT_USER = "insert into " +
            "service_user (first_name, last_name, email, login, password, role) " +
            "values (?, ?, ?, ?, ?, ?);";

    //language=SQL
    private final static String SQL_SELECT_ALL = "select * from service_user";

    //language=SQL
    private final static String SQL_SELECT_ALL_PAGES = "select * from service_user order by id offset ? limit ?";

    //language=SQL
    private final static String SQL_SELECT_ONE_BY_LOGIN = "select * from service_user where login = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    protected static RowMapper<User> userRowMapper = (row, rowNumber) -> User.builder()
            .id(row.getLong("id"))
            .login(row.getString("login"))
            .password(row.getString("password"))
            .firstName(row.getString("first_name"))
            .lastName(row.getString("last_name"))
            .email(row.getString("email"))
            .role(UserRole.valueOf(row.getString("role")))
            .build();

    @Override
    public Optional<User> findOneByLogin(String login) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SQL_SELECT_ONE_BY_LOGIN, userRowMapper, login));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<User> findOneById(Long id) {
        return Optional.empty();
    }

    @Override
    public User save(User model) {

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(con -> {
            PreparedStatement statement = con.prepareStatement(SQL_INSERT_USER, new String[]{"id"});
            statement.setString(1, model.getFirstName());
            statement.setString(2, model.getLastName());
            statement.setString(3, model.getEmail());
            statement.setString(4, model.getLogin());
            statement.setString(5, model.getPassword());
            statement.setString(6, model.getRole().toString());
            return statement;
        }, keyHolder);

        model.setId(keyHolder.getKey().longValue());
        return model;
    }

    @Override
    public void update(User model) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, userRowMapper);
    }

    @Override
    public List<User> findAllByPage(int pageId, int siteCount) {
        return jdbcTemplate.query(SQL_SELECT_ALL_PAGES, userRowMapper, pageId, siteCount);
    }
}
