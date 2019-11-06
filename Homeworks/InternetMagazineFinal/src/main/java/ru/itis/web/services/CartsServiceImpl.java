package ru.itis.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.web.dto.ArticleDto;
import ru.itis.web.dto.CartArticleDto;
import ru.itis.web.dto.CartDto;
import ru.itis.web.dto.UserDto;
import ru.itis.web.models.Article;
import ru.itis.web.models.Cart;
import ru.itis.web.models.User;
import ru.itis.web.repositories.ArticleRepository;
import ru.itis.web.repositories.CartsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CartsServiceImpl implements CartsService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private CartsRepository cartsRepository;

    @Override
    public Cart getCartByUserId(Long userId) {
        return cartsRepository.findByUser_Id(userId).get();
    }

    @Override
    public Long getCartIdByUserId(Long userId) {
        Optional<Cart> cartCandidate = cartsRepository.findByUser_Id(userId);
        return cartCandidate.get().getId();
    }

    @Override
    @Transactional
    public void deleteArticleFromCart(Long cartId, Long articleId) {
        Cart cart = cartsRepository.getOne(cartId);
        //cart.getArticles().removeIf(article -> article.getId().equals(articleId));
        Article article = articleRepository.findById(articleId).get();
        cart.getArticles().remove(article);
        cartsRepository.save(cart);
    }

    @Override
    @Transactional
    public void addArticleToCart(Long userId, Long articleId) {
        Optional <Cart> cartCandidate = cartsRepository.findByUser_Id(userId);
        Cart cart = cartCandidate.get();
        cart.getArticles().add(Article.builder().Id(articleId).build());
        cartsRepository.save(cart);
    }

    @Override
    public Integer getCountArticlesByCartId(Long cartId) {
        return cartsRepository.getCountArticlesByCartId(cartId);
    }

    @Override
    public Float getSumArticlesByCartId(Long cartId) {
        return cartsRepository.getSumArticlesByCartId(cartId);
    }

    @Override
    @Transactional
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

        List<Article> articles = cartsRepository.getOne(cartId).getArticles();

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
