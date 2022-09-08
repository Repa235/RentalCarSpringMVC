package com.example.rentalcarspringmvc.controller;

import com.example.rentalcarspringmvc.dto.VeicoloDto;
import com.example.rentalcarspringmvc.entities.Utente;
import com.example.rentalcarspringmvc.entities.Veicolo;
import com.example.rentalcarspringmvc.mapper.VeicoloMapper;
import com.example.rentalcarspringmvc.service.UtenteService;
import com.example.rentalcarspringmvc.service.VeicoloService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static com.example.rentalcarspringmvc.util.MetodiUtil.getUserFromSession;

@Controller
@RequestMapping("/veicolo")
public class VeicoloController {


    private final VeicoloService veicoloService;
    private final UtenteService utenteService;

    public VeicoloController(VeicoloService veicoloService, UtenteService utenteService) {
        this.veicoloService = veicoloService;
        this.utenteService = utenteService;
    }

    @GetMapping()
    public String visualizzaAllVeicoli(Model model){
        List<Veicolo> veicoli = veicoloService.getVeicoli();
        model.addAttribute("ListVeicoli", veicoli);
        return "veicoli";
    }

    @GetMapping("/visualizzaVeicoliUtente")
    public String visualizzaVeicoliUtente(Model model){
        List<Veicolo> veicoli = veicoloService.getVeicoli();
        model.addAttribute("ListVeicoli", veicoli);
        return "visualizzaVeicoliUtente";
    }

    @GetMapping("/formVeicolo")
    public String formVeicolo(Model model){
        String username = getUserFromSession();
        Utente u = utenteService.getUsersByUsername(username).get(0);
        Utente superuser = utenteService.getUtente(u.getId());
        model.addAttribute("superuser", superuser);
        model.addAttribute("veicoloDto", new VeicoloDto());
        return "formVeicolo";
    }
    @PostMapping("/aggiungiVeicolo")
    public String aggiungiVeicolo(@ModelAttribute("veicoloDto") VeicoloDto veicoloDto){
        Veicolo v = VeicoloMapper.fromDtoToEntityAdd(veicoloDto);
        veicoloService.saveOrUpdateVeicolo(v);
        return "redirect: ../utente/profiloSuperuser";
    }
}
