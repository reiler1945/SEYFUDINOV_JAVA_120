package ru.itis.web.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.itis.web.dto.SignUpForm;
import ru.itis.web.services.UsersService;

@Controller
public class SignUpController {

    @Autowired
    private UsersService usersService;

    @PostMapping(value = "/email/confirm")
    public String emailConfirm(@RequestParam("email") String email) {
        usersService.emailConfirm(email);
        return "afterEmailConfirm";
    }

    @GetMapping(value = "/email/confirm")
    public String getEmailConfirmPage() {
        return "emailConfirm";
    }

    @GetMapping( value = "/signUp")
    public String getSignUpPage(@RequestParam(value = "id", required = false) String uuid) {
        if (uuid == null || uuid.equals("") || usersService.isNotValidUUID(uuid)) {
            return "redirect:/email/confirm";
        } else return "signUp";
    }

    @PostMapping(value = "/signUp")
    public String signUp(SignUpForm form,
                         @RequestParam(value = "id", required = false) String uuid) {
        if (uuid == null || uuid.equals("") || usersService.isNotValidUUID(uuid)) {
            return "redirect:/signIn";
        }

        usersService.signUp(uuid, form);
        return "redirect:/signIn";
    }
}
