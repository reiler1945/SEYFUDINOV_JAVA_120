package ru.itis.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping(value = "/users/{pageSize}", method = RequestMethod.GET)
    public String getUsersByPage(Model model, @PathVariable int pageSize, @RequestParam(defaultValue = "1") int pageNum) {
        List<UserDto> users = usersService.getAllUsersByPage(pageSize, pageNum);
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