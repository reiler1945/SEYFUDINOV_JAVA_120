package ru.itis.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.web.dto.ArticleDto;
import ru.itis.web.dto.UserDto;
import ru.itis.web.services.ArticleService;
import ru.itis.web.services.CartsService;

import java.util.List;

@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private CartsService cartsService;

    @RequestMapping(value = "/articles", method = RequestMethod.GET)
    public String getArticlesPage(Model model, @RequestAttribute("user") UserDto user) {
        List<ArticleDto> articles = articleService.getAllArticles();
        model.addAttribute("articles", articles);
        model.addAttribute("cartArticlesCount", cartsService.getCountArticlesByCartId(user.getCartId()));


        return "articles";
    }
}
