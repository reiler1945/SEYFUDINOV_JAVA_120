package ru.itis.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.itis.web.models.Article;
import ru.itis.web.models.Cart;
import ru.itis.web.models.User;

import java.util.List;
import java.util.Optional;

public interface CartsRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByUser_Id(Long userId);

    @Query(nativeQuery = true, value = "select count(*) from fill_carts where cart_id = :cart_id_")
    Integer getCountArticlesByCartId (@Param("cart_id_") Long cartId);

    @Query(nativeQuery = true, value = "select sum(art.price) from fill_carts fc inner join articles art on art.id = fc.article_id where fc.cart_id = :cart_id_")
    Float getSumArticlesByCartId(@Param("cart_id_") Long cartId);
}
