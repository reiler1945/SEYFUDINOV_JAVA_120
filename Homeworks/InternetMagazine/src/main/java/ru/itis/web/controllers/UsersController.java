package ru.itis.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.web.dto.CartDto;
import ru.itis.web.dto.UserDto;
import ru.itis.web.models.Cart;
import ru.itis.web.repositories.CartsRepository;
import ru.itis.web.services.CartsService;
import ru.itis.web.services.UsersService;

import java.util.List;

@Controller
public class UsersController {
    @Autowired
    private UsersService usersService;

    @Autowired
    private CartsService cartsService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getUsersPage(Model model) {
        List<UserDto> users = usersService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @RequestMapping(value = "/users/carts", method = RequestMethod.GET)
    public String getUsersCartsPage(Model model) {
        List<CartDto> cartDtos = cartsService.getAllCarts();
        model.addAttribute("cartDtos", cartDtos);
        return "usersCarts";
    }

    @RequestMapping(value = "/users/{pageId}", method = RequestMethod.GET)
    public String getUsersByPage(Model model, @PathVariable int pageId, @RequestParam int site) {
        List<UserDto> users = usersService.getAllUsersByPage(pageId, site);
        model.addAttribute("users", users);
        return "usersPages";
    }
}