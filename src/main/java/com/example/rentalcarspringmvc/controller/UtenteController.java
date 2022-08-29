package com.example.rentalcarspringmvc.controller;

import com.example.rentalcarspringmvc.entities.Utente;
import com.example.rentalcarspringmvc.entities.Veicolo;
import com.example.rentalcarspringmvc.repository.UtenteDao;
import com.example.rentalcarspringmvc.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/utente")
public class UtenteController {

    @Autowired
    private UtenteService utenteService;

    @GetMapping("/profiloCustomer")
    public String profiloCustomer(Model model) {
        Utente utente = utenteService.getUtente(Long.parseLong("2"));
        model.addAttribute("utente", utente);

        return "profiloCustomer";
    }
}
