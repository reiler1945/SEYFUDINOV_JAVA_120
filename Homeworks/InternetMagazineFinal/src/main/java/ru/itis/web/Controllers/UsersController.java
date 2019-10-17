package ru.itis.web.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.web.dto.CartDto;
import ru.itis.web.dto.UserDto;
import ru.itis.web.security.details.UserDetailsImpl;
import ru.itis.web.services.CartsService;
import ru.itis.web.services.UsersService;
import ru.itis.web.utils.UserAuthenticationUtil;

import java.util.List;

@Controller
public class UsersController {
    @Autowired
    private UsersService usersService;

    @Autowired
    private CartsService cartsService;

    @Autowired
    private UserAuthenticationUtil authenticationUtil;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getUsersPage(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model) {
        List<UserDto> users = usersService.getAllUsers();
        UserDto user = authenticationUtil.getUserByUserDetails(userDetails);
        model.addAttribute("users", users);
        user.setCartId(cartsService.getCartIdByUserId(user.getId()));
        model.addAttribute("user", user);
        model.addAttribute("cartArticlesCount", cartsService.getCountArticlesByCartId(user.getCartId()));
        return "users";
    }

    @RequestMapping(value = "/users/carts", method = RequestMethod.GET)
    public String getUsersCartsPage(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model) {
        UserDto user = authenticationUtil.getUserByUserDetails(userDetails);
        List<CartDto> cartDtos = cartsService.getAllCarts();
        model.addAttribute("cartDtos", cartDtos);
        user.setCartId(cartsService.getCartIdByUserId(user.getId()));
        model.addAttribute("user", user);
        model.addAttribute("cartArticlesCount", cartsService.getCountArticlesByCartId(user.getCartId()));
        return "usersCarts";
    }

    @RequestMapping(value = "/users/pages", method = RequestMethod.GET)
    public String getUsersByPage(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model, @RequestParam int pageSize, @RequestParam(defaultValue = "1") int pageNum) {
        UserDto user = authenticationUtil.getUserByUserDetails(userDetails);
        user.setCartId(cartsService.getCartIdByUserId(user.getId()));
        model.addAttribute("user", user);
        model.addAttribute("cartArticlesCount", cartsService.getCountArticlesByCartId(user.getCartId()));
        int offset = pageSize * (pageNum - 1);
        List<UserDto> users = usersService.getAllUsersByPage(pageSize, offset);
        Integer rowCount = usersService.getCountUsers();
        Integer pageCount = rowCount / pageSize;
        if (rowCount % pageSize > 0) {
            pageCount++;
        };
        model.addAttribute("pageCount", pageCount);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("pageNum", pageNum);
        model.addAttribute("users", users);
        return "usersPages";
    }

//    @RequestMapping(value = "/usersPage", method = RequestMethod.GET,
//            produces = MediaType.TEXT_PLAIN_VALUE,
//            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @ResponseBody
//    public List<UserDto> getUsersByPageJson(@RequestParam int pageSize, @RequestParam(defaultValue = "1") int pageNum) {
//        List<UserDto> users = usersService.getAllUsersByPage(pageSize, pageNum);
//        Integer rowCount = usersService.getCountUsers();
//        Integer pageCount = rowCount / pageSize;
//        if (rowCount % pageSize > 0) {
//            pageCount++;
//        };
//        return users;
//    }
}