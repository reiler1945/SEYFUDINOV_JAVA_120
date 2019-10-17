package ru.itis.web.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BootStrapController {
    @RequestMapping(value = "/bootstrap", method = RequestMethod.GET)
    public String getPage() {
        return "bootstrap_test";
    }
}
