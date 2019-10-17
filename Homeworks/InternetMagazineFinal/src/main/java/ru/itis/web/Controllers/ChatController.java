package ru.itis.web.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.web.dto.UserDto;
import ru.itis.web.models.Message;
import ru.itis.web.security.details.UserDetailsImpl;
import ru.itis.web.services.CartsService;
import ru.itis.web.services.MessageService;
import ru.itis.web.utils.UserAuthenticationUtil;

@Controller
public class ChatController {

    @Autowired
    MessageService messageService;

    @Autowired
    CartsService cartsService;

    @Autowired
    private UserAuthenticationUtil authenticationUtil;

    @MessageMapping("/message")
    @SendTo("/chat/messages")
    public Message getMessages(Message message) {
        System.out.println(message);
        messageService.saveMessage(message);
        return message;
    }

    @GetMapping(value = "/chat")
    public String addArticlesPageGet(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model) {
        UserDto user = authenticationUtil.getUserByUserDetails(userDetails);
        model.addAttribute("user", user);
        user.setCartId(cartsService.getCartIdByUserId(user.getId()));
        model.addAttribute("cartArticlesCount", cartsService.getCountArticlesByCartId(user.getCartId()));
        return "chat";
    }
}
