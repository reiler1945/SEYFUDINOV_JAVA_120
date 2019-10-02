package ru.itis.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.web.dto.ArticleDto;
import ru.itis.web.dto.CartArticleDto;
import ru.itis.web.dto.UserDto;
import ru.itis.web.models.Article;
import ru.itis.web.models.Cart;
import ru.itis.web.services.CartsService;

import java.util.List;

@Controller
public class CartsController {
    @Autowired
    private CartsService cartsService;

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String getArticlesPage(Model model, @RequestAttribute("user") UserDto user) {
        Long cartId = user.getCartId();
        model.addAttribute("cartId", cartId);
        model.addAttribute("cartArticlesCount", cartsService.getCountArticlesByCartId(cartId));
        model.addAttribute("cartArticlesSum", cartsService.getSumArticlesByCartId(cartId));
        List<CartArticleDto> articles = cartsService.getArticlesByCartId(cartId);
        model.addAttribute("articles", articles);

        return "cart";
    }

    @RequestMapping(value = "/cart", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Integer addArticleToCart(@RequestBody CartArticleDto form) {
        cartsService.addArticleToCart(form.getCartId(), form.getArticleId());
        return cartsService.getCountArticlesByCartId(form.getCartId());
    }

    @RequestMapping(value = "/cart/delete", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<CartArticleDto> deleteArticleFromCart(@RequestBody CartArticleDto form) {
        cartsService.deleteArticleFromCart(form.getCartId(), form.getArticleId());
        return cartsService.getArticlesByCartId(form.getCartId());
    }
}
