package ru.itis.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.web.models.Article;
import ru.itis.web.services.ArticleService;
import ru.itis.web.services.UsersService;

import java.util.List;

@Controller
public class ProfileController {

    @RequestMapping(value = "/profile")
    public String getProfilePage() {
        return "profile";
    }
}
