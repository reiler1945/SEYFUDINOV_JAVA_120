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
import ru.itis.web.models.User;
import ru.itis.web.models.UserRole;
import ru.itis.web.repositories.UsersRepository;

import javax.persistence.NoResultException;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Component(value = "users.repository.jpa.impl")
public class UsersRepositoryJpaImpl implements UsersRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Optional<User> findOneByLogin(String login) {
        Session session = sessionFactory.openSession();
        //Session session = sessionFactory.getCurrentSession();
        try {
            Query<User> userQuery = session.createQuery("from User where login = :login", User.class)
                    .setParameter("login", login);
            User user = userQuery.getSingleResult();
            return Optional.ofNullable(user);
        } catch (NoResultException e) {
            return Optional.empty();
        } finally {
            session.close();
        }
    }

    @Override
    @Transactional
    public Optional<User> findOneById(Long id) {
        return Optional.empty();
    }

    @Override
    @Transactional
    public User save(User model) {
        Session session = sessionFactory.getCurrentSession();
//        Transaction transaction = session.beginTransaction();
        session.persist(model);
//        transaction.commit();
        return model;
    }

    @Override
    @Transactional
    public void update(User model) {
        Session session = sessionFactory.getCurrentSession();
//        Transaction transaction = session.beginTransaction();
        session.merge(model);
//        transaction.commit();
    }

    @Override
    @Transactional
    public void delete(Long id) {

    }

    @Override
    @Transactional
    public List<User> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<User> userQuery = session.createQuery("from User", User.class);
        List<User> users = userQuery.getResultList();
        return users;
    }

    @Override
    @Transactional
    public List<User> findAllByPage(int pageSize, int pageNum) {
        //TODO:
        return null;
//        int offset = pageSize * (pageNum - 1);
//        return jdbcTemplate.query(SQL_SELECT_ALL_PAGES, userRowMapper, pageSize, offset);
    }

    @Override
    @Transactional
    public Integer getCountUsers() {
        //TODO:
        return null;
    }
}
