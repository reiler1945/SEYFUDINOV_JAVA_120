package ru.itis.web.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.itis.web.dto.SignInForm;
import ru.itis.web.services.UsersService;
import ru.itis.web.utils.UserAuthenticationUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
public class SignInController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
    public String getSignInPage() {
        return "signIn";
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public String userSignIn(HttpServletResponse response, SignInForm form) {
        usersService.signIn(form);
        Optional<String> cookieCandidate = usersService.signIn(form);
        if (cookieCandidate.isPresent()) {
            Cookie cookie = new Cookie("clientId", cookieCandidate.get());
            response.addCookie(cookie);
            return "redirect:/profile";
        } else {
            return "redirect:/signIn";
        }
    }
}
