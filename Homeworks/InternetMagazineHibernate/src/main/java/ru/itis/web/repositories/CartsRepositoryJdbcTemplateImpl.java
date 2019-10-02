package ru.itis.web.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import ru.itis.web.models.Article;
import ru.itis.web.models.Cart;
import ru.itis.web.models.User;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Component(value = "carts.repository.jdbc.template.impl")
public class CartsRepositoryJdbcTemplateImpl implements CartsRepository {

    //language=SQL
    private static final String SQL_FIND_ARTICLES_BY_USER_ID =
            "select arts.article_id, arts.name, arts.price from carts, fill_carts, articles arts" +
            "  where carts.cart_id = fill_carts.cart_id" +
            "    and fill_carts.article_id = arts.article_id " +
            "    and carts.user_id = ?;";

    //language=SQL
    private static final String SQL_FIND_ARTICLES_BY_CART_ID =
            "select arts.article_id, arts.name, arts.price from fill_carts, articles arts" +
                    "  where fill_carts.article_id = arts.article_id " +
                    "    and fill_carts.cart_id = ?;";

    //language=SQL
    private static final String SQL_FIND_ALL = "select arts.*, su.id, su.*, carts.cart_id\n" +
            "                                        from service_user su left join carts on su.id = carts.user_id\n" +
            "                                             left join fill_carts on carts.cart_id = fill_carts.cart_id\n" +
            "                                             left join articles arts on fill_carts.article_id = arts.article_id";

    //language=SQL
    private static final String SQL_INSERT_CART = "insert into carts(user_id) values (?)";

    //language=SQL
    private static final String SQL_INSERT_ARTICLES_TO_CART = "insert into fill_carts(cart_id, article_id) values (?, ?)";

    //language=SQL
    private static final String SQL_DELETE_ARTICLES_FROM_CART = "delete from fill_carts where CTID = (select max(CTID) from fill_carts where cart_id = ? and article_id = ?)";

    //language=SQL
    private static final String SQL_COUNT_ARTICLES_BY_CART_ID = "select count(*) as count_articles from fill_carts where cart_id = ?";

    //language=SQL
    private static final String SQL_SUM_PRICE_ARTICLES_BY_CART_ID = "select sum(price) as sum from fill_carts, articles where fill_carts.article_id = articles.article_id and fill_carts.cart_id = ?";

    //language=SQL
    private static final String SQL_CART_ID_BY_USER = "select cart_id from carts where user_id = ?";

    private RowMapper<List<Cart>> cartsRowMapper = (row, rowNumber) -> {
        HashMap<Long, Cart> cartMap = new HashMap<>();
        do {
            Long cartId = row.getLong("cart_id");
            if (!row.wasNull()) {
                if (!cartMap.containsKey(cartId)) {
                    User user = UsersRepositoryJdbcTemplateImpl.userRowMapper.mapRow(row, rowNumber);
                    cartMap.put(cartId, Cart.builder()
                                        .Id(cartId)
                                        .articles(new ArrayList<>())
                                        .user(user)
                                        .build());
                }
                row.getLong("article_id");
                if (!row.wasNull()) {
                    Article article = ArticleRepositoryJdbcTemplateImpl.articleRowMapper.mapRow(row, rowNumber);
                    cartMap.get(cartId).getArticles().add(article);
                }
            }
        } while (row.next());
        return new ArrayList<>(cartMap.values());
    };

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Optional<Cart> findByUser_Id(Long userId) {
        List<Article> articles = jdbcTemplate.query(SQL_FIND_ARTICLES_BY_USER_ID, ArticleRepositoryJdbcTemplateImpl.articleRowMapper, userId);
        return Optional.ofNullable(Cart.builder().articles(articles).build());
    }

    @Override
    public void deleteArticleFromCart(Long cartId, Long articleId) {
        jdbcTemplate.update(con -> {
            PreparedStatement statement = con.prepareStatement(SQL_DELETE_ARTICLES_FROM_CART);
            statement.setLong(1, cartId);
            statement.setLong(2, articleId);
            return statement;
        });
    }

    @Override
    public void addArticleToCart(Long cartId, Long articleId) {
        jdbcTemplate.update(con -> {
            PreparedStatement statement = con.prepareStatement(SQL_INSERT_ARTICLES_TO_CART);
            statement.setLong(1, cartId);
            statement.setLong(2, articleId);
            return statement;
        });
    }

    @Override
    public Cart save(Cart model) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(con -> {
            PreparedStatement statement = con.prepareStatement(SQL_INSERT_CART, new String[]{"cart_id"});
            statement.setLong(1, model.getUser().getId());
            return statement;
        }, keyHolder);

        model.setId(keyHolder.getKey().longValue());
        return model;
    }

    @Override
    public Optional<Cart> findOneById(Long id) {
        return Optional.empty();
    }

    @Override
    public void update(Cart model) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Cart> findAll() {
        return jdbcTemplate.queryForObject(SQL_FIND_ALL, cartsRowMapper);
    }


    @Override
    public Integer getCountArticlesByCartId(Long cartId) {
        return jdbcTemplate.queryForObject(SQL_COUNT_ARTICLES_BY_CART_ID, Integer.class, cartId);
    }

    @Override
    public Float getSumArticlesByCartId(Long cartId) {
        return jdbcTemplate.queryForObject(SQL_SUM_PRICE_ARTICLES_BY_CART_ID, Float.class, cartId);
    }

    @Override
    public Long CartIdByUser_Id(Long userId) {
        return jdbcTemplate.queryForObject(SQL_CART_ID_BY_USER, Long.class, userId);
    }

    @Override
    public List<Article> getArticlesByCartId(Long cartId) {
        return jdbcTemplate.query(SQL_FIND_ARTICLES_BY_CART_ID, ArticleRepositoryJdbcTemplateImpl.articleRowMapper, cartId);
    }
}
