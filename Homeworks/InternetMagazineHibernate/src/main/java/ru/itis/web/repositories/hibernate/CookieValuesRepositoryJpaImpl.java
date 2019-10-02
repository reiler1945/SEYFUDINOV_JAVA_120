package ru.itis.web.repositories.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.web.models.CookieValue;
import ru.itis.web.models.User;
import ru.itis.web.repositories.CookieValuesRepository;

import javax.persistence.NoResultException;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Component(value = "cookie.values.repository.jpa.impl")
public class CookieValuesRepositoryJpaImpl implements CookieValuesRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public Optional<CookieValue> findOneByValue(String value) {
        Session session = sessionFactory.getCurrentSession();
        try {
            Query<CookieValue> cookieValueQuery = session.createQuery("from CookieValue where value = :value", CookieValue.class)
                    .setParameter("value", value);
            CookieValue cookieValue = cookieValueQuery.getSingleResult();
            return Optional.ofNullable(cookieValue);
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    @Transactional
    public Optional<CookieValue> findOneById(Long id) {
        return Optional.empty();
    }

    @Override
    @Transactional
    public CookieValue save(CookieValue model) {
        Session session = sessionFactory.getCurrentSession();
//        Transaction transaction = session.beginTransaction();
        session.persist(model);
//        transaction.commit();
        return model;
    }

    @Override
    @Transactional
    public void update(CookieValue model) {

    }

    @Override
    @Transactional
    public void delete(Long id) {

    }

    @Override
    @Transactional
    public List<CookieValue> findAll() {
        return null;
    }
}
