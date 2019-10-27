package ru.itis.web.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itis.web.dto.UserDto;
import ru.itis.web.security.details.UserDetailsImpl;
import ru.itis.web.services.CartsService;
import ru.itis.web.utils.UserAuthenticationUtil;

@Controller
public class PayPageController {
    @Autowired
    private CartsService cartsService;

    @Autowired
    private UserAuthenticationUtil authenticationUtil;

    @RequestMapping(value = "/pay", method = RequestMethod.GET)
    public String getArticlesPage(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        UserDto user = authenticationUtil.getUserByUserDetails(userDetails);
        Long cartId = cartsService.getCartIdByUserId(user.getId());
        user.setCartId(cartsService.getCartIdByUserId(user.getId()));
        model.addAttribute("cartId", cartId);
        model.addAttribute("user", user);
        model.addAttribute("cartArticlesCount", cartsService.getCountArticlesByCartId(cartId));
        model.addAttribute("cartArticlesSum", cartsService.getSumArticlesByCartId(cartId));
        return "payPage";
    }
}
