package ru.itis.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.itis.web.dto.ArticleDto;
import ru.itis.web.dto.CartArticleDto;
import ru.itis.web.dto.CartDto;
import ru.itis.web.dto.UserDto;
import ru.itis.web.models.Article;
import ru.itis.web.models.Cart;
import ru.itis.web.models.User;
import ru.itis.web.repositories.CartsRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class CartsServiceImpl implements CartsService {

    @Autowired
    @Qualifier(value = "carts.repository.jpa.impl")
    private CartsRepository cartsRepository;

    @Override
    public Cart getCartByUserId(Long userId) {
        return cartsRepository.findByUser_Id(userId).get();
    }

    @Override
    public Long getCartIdByUserId(Long userId) {
        return cartsRepository.CartIdByUser_Id(userId);
    }

    @Override
    public void deleteArticleFromCart(Long cartId, Long articleId) {
        cartsRepository.deleteArticleFromCart(cartId, articleId);
    }

    @Override
    public void addArticleToCart(Long userId, Long articleId) {
        cartsRepository.addArticleToCart(userId, articleId);
    }

    @Override
    public Integer getCountArticlesByCartId(Long carId) {
        return cartsRepository.getCountArticlesByCartId(carId);
    }

    @Override
    public Float getSumArticlesByCartId(Long carId) {
        return cartsRepository.getSumArticlesByCartId(carId);
    }

    @Override
    public void addCartToUserId(Long userId) {
        Cart cart = Cart.builder()
                .user(User.builder()
                        .id(userId)
                        .build())
                .build();
        cartsRepository.save(cart);
    }

    @Override
    public List<CartDto> getAllCarts() {
        List<Cart> carts = cartsRepository.findAll();
        List<CartDto> result = new ArrayList<>();
        for (Cart cart : carts) {
            User user = cart.getUser();
            CartDto cartDto = CartDto.builder()
                    .id(cart.getId())
                    .user(UserDto.builder()
                            .firstName(user.getFirstName())
                            .lastName(user.getLastName())
                            .id(user.getId())
                            .build())
                    .build();
            List<ArticleDto> articleDtos = new ArrayList<>();
            for(Article article : cart.getArticles()) {
                articleDtos.add(ArticleDto.builder()
                        .name(article.getName())
                        .id(article.getId())
                        .price(article.getPrice())
                        .build());
            }
            cartDto.setArticles(articleDtos);
            result.add(cartDto);
        }
        return result;
    }

    @Override
    public List<CartArticleDto> getArticlesByCartId(Long cartId) {

        List<Article> articles = cartsRepository.getArticlesByCartId(cartId);

        List<CartArticleDto> result = new ArrayList<>();

        for (Article article : articles) {
            CartArticleDto cartArticleDto = CartArticleDto.builder()
                    .articleId(article.getId())
                    .name(article.getName())
                    .price(article.getPrice())
                    .cartId(cartId)
                    .build();
            result.add(cartArticleDto);
        }
        return result;

    }
}
