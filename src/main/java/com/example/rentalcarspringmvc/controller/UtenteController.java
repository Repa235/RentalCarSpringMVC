package com.example.rentalcarspringmvc.controller;

import com.example.rentalcarspringmvc.dto.UtenteDto;
import com.example.rentalcarspringmvc.entities.Utente;
import com.example.rentalcarspringmvc.entities.Veicolo;
import com.example.rentalcarspringmvc.mapper.UtenteMapper;
import com.example.rentalcarspringmvc.repository.UtenteDao;
import com.example.rentalcarspringmvc.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/utente")
public class UtenteController {

    @Autowired
    private UtenteService utenteService;

    @GetMapping("/profiloCustomer")
    public String profiloCustomer(Model model) {
        Utente customer = utenteService.getUtente(Long.parseLong("2"));
        LocalDate now = LocalDate.now();
        model.addAttribute("customer", customer);
        model.addAttribute("now", now);
        return "profiloCustomer";
    }

    @GetMapping("/profiloSuperuser")
    public String profiloSuperuser(Model model) {
        Utente superuser = utenteService.getUtente(Long.parseLong("1"));
        model.addAttribute("superuser", superuser);
        model.addAttribute("clienti", utenteService.getCustomers());
        return "profiloSuperuser";
    }

    @GetMapping("/searchUtenti")
    public String searchUtenti(Model model, HttpServletRequest request) {
        Utente superuser = utenteService.getUtente(Long.parseLong("1"));
        model.addAttribute("superuser", superuser);
        String filtraPer = request.getParameter("filtraPer");
        String text = request.getParameter("text");
        List<Utente> filtered;
        filtered = utenteService.getCustomerByParam(filtraPer, text);
        model.addAttribute("clienti", filtered);
        return "profiloSuperuser";
    }

    @GetMapping("/formUtente")
    public String formUtente(@RequestParam("customerId") String customerId,
                             @RequestParam("utenteRichiedente") String utenteRichiedente, Model model) {
        if (utenteRichiedente.equals("customer")) {
            Utente customer = utenteService.getUtente(Long.parseLong(customerId));
            model.addAttribute("customer", customer);
            model.addAttribute("customerDto", new UtenteDto());
            return "formUtente";
        } else if (utenteRichiedente.equals("superuser") && customerId.equals("new")) {
            model.addAttribute("customerDto", new UtenteDto());
            return "formUtente4Add";
        } else if (utenteRichiedente.equals("superuser") && !customerId.equals("new")) {
            Utente customer = utenteService.getUtente(Long.parseLong(customerId));
            model.addAttribute("customer", customer);
            model.addAttribute("customerDto", new UtenteDto());
            return "formUtente4Add";
        } else {
            return "redirect: ../";
        }
    }


    @PostMapping("/modificaAggiungiUtente")
    public String modificaAggiungiUtente(@Valid @ModelAttribute("customerDto") UtenteDto customerDto, BindingResult
            result) {
        if (result.hasErrors()) {
            return "formUtente";
        }
        System.out.println(customerDto.getNome());
        String idU = customerDto.getId();
        if (idU.isEmpty() || idU == null) {
            Utente customerToAdd = UtenteMapper.fromDtoToEntityAdd(customerDto);
            utenteService.saveOrUpdateUtente(customerToAdd);
        } else {
            Utente customerToModify = UtenteMapper.fromDtoToEntityModify(customerDto);
            utenteService.saveOrUpdateUtente(customerToModify);
        }
        return "redirect:../";
    }

    @GetMapping("/eliminaUtente")
    public String eliminaUtente(@RequestParam("customerId") String customerId) {
        utenteService.deleteUtente(utenteService.getUtente(Long.parseLong(customerId)));
        return "profiloSuperuser";
    }


}
