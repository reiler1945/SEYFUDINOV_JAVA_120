package ru.itis.web.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import ru.itis.web.models.CookieValue;
import ru.itis.web.models.User;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

public class CookieValueRepositoryJdbcTemplateImpl implements CookieValuesRepository {

    private JdbcTemplate jdbcTemplate;

    public CookieValueRepositoryJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //language=SQL
    private static final String SQL_INSERT_COOKIE = "insert into cookie(value, user_id) values (?, ?)";

    //language=SQL
    private static final String SQL_FIND_BY_VALUE = "select c.value, c.id as cookie_id, su.* " +
            "from cookie c " +
            "       join service_user su on c.user_id = su.id " +
            "where c.value = ?;";

    //language=SQL
    private static final String SQL_DELETE_COOKIE = "delete from cookie where id = ?";

    static RowMapper<CookieValue> cookieRowMapper = (row, rowNumber) -> {
        User user = UsersRepositoryJdbcTemplateImpl.userRowMapper.mapRow(row, rowNumber);
        return CookieValue.builder()
                    .id(row.getLong("cookie_id"))
                    .user(user)
                    .value(row.getString("value"))
                    .build();
    };

    @Override
    public Optional<CookieValue> findOneByValue(String value) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(SQL_FIND_BY_VALUE, cookieRowMapper, value));
    }

    @Override
    public Optional<CookieValue> findOneById(Long id) {
        throw new NotImplementedException();
    }

    @Override
    public CookieValue save(CookieValue model) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement statement = con.prepareStatement(SQL_INSERT_COOKIE, new String[]{"id"});
            statement.setString(1, model.getValue());
            statement.setLong(2, model.getUser().getId());
            return statement;
        }, keyHolder);

        model.setId(keyHolder.getKey().longValue());
        return model;
    }

    @Override
    public void update(CookieValue model) {
        throw new NotImplementedException();
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update(SQL_DELETE_COOKIE, id);
    }

    @Override
    public List<CookieValue> findAll() {
        throw new NotImplementedException();
    }
}
