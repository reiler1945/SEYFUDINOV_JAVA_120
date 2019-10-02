package ru.itis.web.repositories.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.web.models.Article;
import ru.itis.web.repositories.ArticleRepository;

import java.util.List;
import java.util.Optional;

@Component(value = "article.repository.jpa.impl")
public class ArticleRepositoryJpaImpl implements ArticleRepository{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public Optional<Article> findOneById(Long id) {
        return Optional.empty();
    }

    @Override
    @Transactional
    public Article save(Article model) {
        return null;
    }

    @Override
    @Transactional
    public void update(Article model) {

    }

    @Override
    @Transactional
    public void delete(Long id) {

    }

    @Override
    @Transactional
    public List<Article> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Article> userQuery = session.createQuery("from Article", Article.class);
        List<Article> articles = userQuery.getResultList();
        return articles;
    }
}
