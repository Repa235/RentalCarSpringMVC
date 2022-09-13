package com.example.rentalcarspringmvc.controller;

import com.example.rentalcarspringmvc.dto.UtenteDto;
import com.example.rentalcarspringmvc.entities.Prenotazione;
import com.example.rentalcarspringmvc.entities.Utente;
import com.example.rentalcarspringmvc.mapper.UtenteMapper;
import com.example.rentalcarspringmvc.service.UtenteService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.logging.Logger;

import static com.example.rentalcarspringmvc.util.MetodiUtil.getUserFromSession;


@Controller
@RequestMapping("/utente")
public class UtenteController {
    private static final Logger LOGGER = Logger.getLogger("UtenteController");
    private final UtenteService utenteService;
    private final BCryptPasswordEncoder passwordEncoder;

    public UtenteController(UtenteService utenteService, BCryptPasswordEncoder passwordEncoder) {
        this.utenteService = utenteService;
        this.passwordEncoder = passwordEncoder;
    }


    @GetMapping("/toProfilo")
    public String toProfilo() {
        String username = getUserFromSession();
        LOGGER.info(username);
        if (username == "anonymousUser") {
            return "redirect: ../form/login";
        } else {
            Utente u = utenteService.getUsersByUsername(username);
            if (u.getTipo().equals("customer")) {
                return "redirect: ../utente/profiloCustomer";
            } else {
                return "redirect: ../utente/profiloSuperuser";
            }
        }
    }


    @GetMapping("/profiloCustomer")
    public String profiloCustomer(Model model) {
        String username = getUserFromSession();
        Utente customer = utenteService.getUsersByUsername(username);
        LocalDate now = LocalDate.now();
        model.addAttribute("customer", customer);
        model.addAttribute("now", now);
        return "profiloCustomer";
    }

    @GetMapping("/profiloSuperuser")
    public String profiloSuperuser(Model model) {
        String username = getUserFromSession();
        Utente superuser = utenteService.getUsersByUsername(username);
        model.addAttribute("superuser", superuser);
        model.addAttribute("clienti", utenteService.getCustomers());
        return "profiloSuperuser";
    }

    @GetMapping("/searchUtenti")
    public String searchUtenti(Model model, HttpServletRequest request) {
        String username = getUserFromSession();
        model.addAttribute("superuser", utenteService.getUsersByUsername(username));
        String filtraPer = request.getParameter("filtraPer");
        String text = request.getParameter("text");
        model.addAttribute("clienti", utenteService.getCustomerByParam(filtraPer, text));
        return "profiloSuperuser";
    }

    @GetMapping("/formUtente")
    public String formUtente(@RequestParam("customerId") String customerIdString,
                             @RequestParam("utenteRichiedente") String utenteRichiedente, Model model) {
        Utente u = utenteService.getUsersByUsername(getUserFromSession());
        model.addAttribute("customerDto", new UtenteDto());
        switch (u.getTipo()) {
            case "customer":
                model.addAttribute("customer", u);
                return "formUtente";
            case "superuser":
                model.addAttribute("superuser", u);
                if (!customerIdString.equals("new")) {
                    Utente customer = utenteService.getUtente(Long.parseLong(customerIdString));
                    model.addAttribute("customer", customer);
                }
                return "formUtente4Add";
            default:
                return "redirect: ../";
        }
    }



    @PostMapping("/modificaAggiungiUtente")
    public String modificaAggiungiUtente(@Valid @ModelAttribute("customerDto") UtenteDto customerDto, BindingResult
            result) {
        if (result.hasErrors()) {
            return "formUtente";
        }
        customerDto.setPassword(passwordEncoder.encode(customerDto.getPassword()));
        Utente u = customerDto.getId()==null?
                new Utente() : utenteService.getUtente(customerDto.getId());
                    UtenteMapper.fromDtoToEntity(customerDto);
            utenteService.saveOrUpdateUtente(u);
        return "redirect:../";
    }

    @GetMapping("/eliminaUtente")
    public String eliminaUtente(@RequestParam("customerId") String customerId) {
        utenteService.deleteUtente(Long.parseLong(customerId));
        return "redirect: profiloSuperuser";
    }


}
