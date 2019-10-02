package ru.itis.web.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itis.web.dto.ArticleDto;
import ru.itis.web.dto.CartDto;
import ru.itis.web.dto.UserDto;
import ru.itis.web.models.User;
import ru.itis.web.security.details.UserDetailsImpl;
import ru.itis.web.services.ArticleService;
import ru.itis.web.services.CartsService;
import ru.itis.web.utils.UserAuthenticationUtil;

import java.util.List;

@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private CartsService cartsService;

    @Autowired
    private UserAuthenticationUtil authenticationUtil;

    @RequestMapping(value = "/articles", method = RequestMethod.GET)
    public String getArticlesPage(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        List<ArticleDto> articles = articleService.getAllArticles();
        UserDto user = authenticationUtil.getUserByUserDetails(userDetails);
        model.addAttribute("articles", articles);
        model.addAttribute("user", user);
        user.setCartId(cartsService.getCartIdByUserId(user.getId()));
        model.addAttribute("cartArticlesCount", cartsService.getCountArticlesByCartId(user.getCartId()));

        return "articles";
    }
}
