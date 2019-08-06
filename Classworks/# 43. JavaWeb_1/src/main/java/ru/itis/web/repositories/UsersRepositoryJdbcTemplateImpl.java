package ru.itis.web.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import ru.itis.web.models.User;
import ru.itis.web.models.UserRole;

import java.sql.PreparedStatement;
import java.sql.Types;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {

    private JdbcTemplate jdbcTemplate;

    public UsersRepositoryJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //language=SQL
    private static final String SQL_ALL_USERS = "select * from service_user";

    //language=SQL
    private static final String SQL_ONE_USER_BY_LOGIN = "select * from service_user where login = ?";

    //language=SQL
    private static final String SQL_ONE_USER_BY_ID = "select * from service_user where id = ?";

    //language=SQL
    private static final String SQL_CREATE_USER = "insert into service_user (first_name, last_name, age, phone, email, login, password, role) values (?, ?, ?, ?, ?, ?, ?, ?)";

    //language=SQL
    private static final String SQL_DELETE_USER = "delete from service_user where id = ?";

    //language=SQL
    private static final String SQL_UPDATE_USER = "update service_user set first_name = ?, last_name = ?, age = ?, phone = ?, email = ?, login = ?, password = ?, role = ? where id = ?";

    static RowMapper<User> userRowMapper = (row, rowNumber) -> User.builder()
            .id(row.getLong("id"))
            .login(row.getString("login"))
            .password(row.getString("password"))
            .firstName(row.getString("first_name"))
            .lastName(row.getString("last_name"))
            .age(row.getInt("age"))
            .phone(row.getString("phone"))
            .email(row.getString("email"))
            .role(UserRole.valueOf(row.getString("role")))
            .build();

    @Override
    public Optional<User> findOneByLogin(String login) {
        return Optional.ofNullable(jdbcTemplate.queryForObject (SQL_ONE_USER_BY_LOGIN, userRowMapper, login));
    }

    @Override
    public Optional<User> findOneById(Long id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject (SQL_ONE_USER_BY_ID, userRowMapper, id));
    }

    @Override
    public User save(User model) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement statement = con.prepareStatement(SQL_CREATE_USER, new String[]{"id"});
            statement.setString(1, model.getFirstName());
            statement.setString(2, model.getLastName());
            statement.setObject(3, model.getAge());
            statement.setString(4, model.getPhone());
            statement.setString(5, model.getEmail());
            statement.setString(6, model.getLogin());
            statement.setString(7, model.getPassword());
            statement.setString(8, model.getRole().toString());
            return statement;
        }, keyHolder);

        model.setId(keyHolder.getKey().longValue());
        return model;
    }

    @Override
    public void update(User model){
        jdbcTemplate.update(SQL_UPDATE_USER,
                model.getFirstName(),
                model.getLastName(),
                model.getAge(),
                model.getPhone(),
                model.getEmail(),
                model.getLogin(),
                model.getPassword(),
                model.getRole().toString(),
                model.getId());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update(SQL_DELETE_USER, id);
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(SQL_ALL_USERS, userRowMapper);
    }
}
