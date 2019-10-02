package ru.itis.web.repositories;

import ru.itis.web.models.Article;
import ru.itis.web.models.Cart;

import java.util.List;
import java.util.Optional;

public interface CartsRepository extends CrudRepository<Cart> {
    Optional<Cart> findByUser_Id(Long userId);
    Long CartIdByUser_Id(Long userId);
    void addArticleToCart(Long CartId, Long articleId);
    void deleteArticleFromCart(Long cartId, Long articleId);
    Integer getCountArticlesByCartId(Long cartId);
    Float getSumArticlesByCartId(Long cartId);
    List<Article> getArticlesByCartId(Long cartId);
}
