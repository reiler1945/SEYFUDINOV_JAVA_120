package ru.itis.web.services;

import ru.itis.web.dto.CartArticleDto;
import ru.itis.web.dto.CartDto;
import ru.itis.web.models.Cart;

import java.util.List;

public interface CartsService {
    Long getCartIdByUserId(Long userId);
    Cart getCartByUserId(Long userId);
    void addCartToUserId(Long userId);
    void addArticleToCart(Long cartId, Long articleId);
    void deleteArticleFromCart(Long cartId, Long articleId);
    Integer getCountArticlesByCartId(Long cartId);
    Float getSumArticlesByCartId(Long cartId);
    List<CartArticleDto> getArticlesByCartId(Long cartId);
    List<CartDto> getAllCarts();
}
