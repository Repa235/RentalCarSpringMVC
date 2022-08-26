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
        model.addAttribute("Intestazione", "Affitta da noi l'auto che desideri");
        model.addAttribute("ciao", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
                "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, " +
                "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure " +
                "dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur" +
                " sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
        );
        return "index";
    }

}
