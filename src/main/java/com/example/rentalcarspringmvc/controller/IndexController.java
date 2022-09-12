package com.example.rentalcarspringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class IndexController {


    @RequestMapping
    public String getWelcome2(Model model) {
        return "index";
    }

    @RequestMapping("/Homepage")
    public String getWelcome3(Model model) {
        return "index";
    }

}
