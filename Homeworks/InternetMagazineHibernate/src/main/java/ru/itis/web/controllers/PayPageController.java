package ru.itis.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.web.dto.CartArticleDto;
import ru.itis.web.dto.UserDto;
import ru.itis.web.services.CartsService;

import java.util.List;

@Controller
public class PayPageController {
    @Autowired
    private CartsService cartsService;

    @RequestMapping(value = "/pay", method = RequestMethod.GET)
    public String getArticlesPage(Model model, @RequestAttribute("user") UserDto user) {
        Long cartId = user.getCartId();
        model.addAttribute("cartArticlesCount", cartsService.getCountArticlesByCartId(cartId));
        model.addAttribute("cartArticlesSum", cartsService.getSumArticlesByCartId(cartId));
        return "payPage";
    }
}
