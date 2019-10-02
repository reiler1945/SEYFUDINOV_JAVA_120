package ru.itis.web.repositories.hibernate;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.web.models.Article;
import ru.itis.web.models.Cart;
import ru.itis.web.models.User;
import ru.itis.web.repositories.CartsRepository;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Component(value = "carts.repository.jpa.impl")
public class CartsRepositoryJpaImpl implements CartsRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public Optional<Cart> findByUser_Id(Long userId) {
        Session session = sessionFactory.getCurrentSession();
        Query<Cart> cartQuery = session.createQuery("from Cart as cart where cart.user_id = :userId", Cart.class)
                .setParameter("userId", userId);
        return Optional.ofNullable(cartQuery.getSingleResult());
    }

    @Override
    @Transactional
    public void deleteArticleFromCart(Long cartId, Long articleId) {
        Session session = sessionFactory.getCurrentSession();
        Cart cart = session.get(Cart.class, cartId);
        cart.getArticles().removeIf(article -> article.getId() == articleId);
        session.merge(cart);
    }

    @Override
    @Transactional
    public void addArticleToCart(Long cartId, Long articleId) {
        Session session = sessionFactory.getCurrentSession();
        Cart cart = session.get(Cart.class, cartId);
        cart.getArticles().add(Article.builder().Id(articleId). build());
        session.merge(cart);
    }

    @Override
    @Transactional
    public Cart save(Cart model) {
        Session session = sessionFactory.getCurrentSession();
//        Transaction transaction = session.beginTransaction();
        session.persist(model);
//        transaction.commit();
        return model;
    }

    @Override
    @Transactional
    public Optional<Cart> findOneById(Long id) {
        return Optional.empty();
    }

    @Override
    @Transactional
    public void update(Cart model) {

    }

    @Override
    @Transactional
    public void delete(Long id) {

    }

    @Override
    @Transactional
    public List<Cart> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Cart> cartQuery = session.createQuery("from Cart", Cart.class);
        List<Cart> carts = cartQuery.getResultList();
        return carts;
    }


    @Override
    @Transactional
    public Integer getCountArticlesByCartId(Long cartId) {
        Session session = sessionFactory.getCurrentSession();
        Cart cart = session.get(Cart.class, cartId);
        return cart.getArticles().size();
//        Query<Long> integerQuery = session.createQuery("select count(*) from Cart.articles where cartId = :cartId", Long.class)
//                .setParameter("cartId", cartId);
//        return integerQuery.getSingleResult().intValue();

    }

    @Override
    @Transactional
    public Float getSumArticlesByCartId(Long cartId) {
        Session session = sessionFactory.getCurrentSession();
        Query<Double> query = session.createSQLQuery("select sum(price) as sum from fill_carts, articles where fill_carts.article_id = articles.id and fill_carts.cart_id = :cartId")
                .setParameter("cartId", cartId);
        return query.getSingleResult().floatValue();
    }

    @Override
    @Transactional
    public Long CartIdByUser_Id(Long userId) {
        Session session = sessionFactory.getCurrentSession();
        Query<Long> longQuery = session.createQuery("select cart.id from Cart as cart where cart.user.id = :userId", Long.class)
                .setParameter("userId", userId);
        return longQuery.getSingleResult();
    }

    @Override
    @Transactional
    public List<Article> getArticlesByCartId(Long cartId) {
        Session session = sessionFactory.getCurrentSession();
//        Cart cart = session. get(Cart.class, cartId);
//        return cart.getArticles();
        Query<Article> query = session.createSQLQuery("select art.* from carts inner join fill_carts fc on carts.id = fc.cart_id join articles art on art.id = fc.article_id where carts.id = :cartId").addEntity(Article.class)
                .setParameter("cartId", cartId);
        return query.getResultList();
    }
}
