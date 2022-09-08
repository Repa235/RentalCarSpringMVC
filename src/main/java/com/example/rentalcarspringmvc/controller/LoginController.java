package com.example.rentalcarspringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login/form")
public class LoginController {
    @GetMapping
    public String getLogin(Model model){
        return "login";
    }
}
