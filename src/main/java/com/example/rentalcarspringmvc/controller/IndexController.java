package com.example.rentalcarspringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class IndexController {
    @RequestMapping(value = "index")
    public String getWelcome(Model model) {
        model.addAttribute("Intestazione", "Intestazione per prova");
        model.addAttribute("ciao", "CIAO");
        return "index";
    }

    @RequestMapping
    public String getWelcome2(Model model) {
        model.addAttribute("Intestazione", "Intestazione");
        model.addAttribute("ciao", "CIAO");
        return "index";
    }

}
