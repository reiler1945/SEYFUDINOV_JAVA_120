package ru.itis.web.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//@Controller
public class TestController{
    @GetMapping(value = "/")
    public String justIn(){
        return "justIn";
    }
}
