package ru.itis.web.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.web.security.details.UserDetailsImpl;
import ru.itis.web.utils.UserAuthenticationUtil;

@Controller
public class ProfileController {

    @Autowired
    private UserAuthenticationUtil authenticationUtil;

    @GetMapping(value = "/profile")
    public String getProfilePage(@AuthenticationPrincipal UserDetailsImpl user, Model model) {
        model.addAttribute("user", authenticationUtil.getUserByUserDetails(user));
        return "profile";
    }
}
