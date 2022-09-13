package com.example.rentalcarspringmvc.controller;

import com.example.rentalcarspringmvc.dto.VeicoloDto;
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

import static com.example.rentalcarspringmvc.util.MetodiUtil.getUserFromSession;

@Controller
@RequestMapping("/veicolo")
public class VeicoloController {


    private final VeicoloService veicoloService;
    private final UtenteService utenteService;
    private final VeicoloMapper veicoloMapper;

    public VeicoloController(VeicoloService veicoloService, UtenteService utenteService, VeicoloMapper veicoloMapper) {
        this.veicoloService = veicoloService;
        this.utenteService = utenteService;
        this.veicoloMapper = veicoloMapper;
    }

    @GetMapping()
    public String visualizzaAllVeicoli(Model model){
        model.addAttribute("ListVeicoli", veicoloService.getVeicoli());
        return "veicoli";
    }

    @GetMapping("/visualizzaVeicoliUtente")
    public String visualizzaVeicoliUtente(Model model){
        model.addAttribute("customer", utenteService.getUsersByUsername(getUserFromSession()));
        model.addAttribute("ListVeicoli", veicoloService.getVeicoli());
        return "visualizzaVeicoliUtente";
    }

    @GetMapping("/formVeicolo")
    public String formVeicolo(Model model){
        model.addAttribute("superuser", utenteService.getUsersByUsername(getUserFromSession()));
        model.addAttribute("veicoloDto", new VeicoloDto());
        return "formVeicolo";
    }
    @PostMapping("/aggiungiVeicolo")
    public String aggiungiVeicolo(@ModelAttribute("veicoloDto") VeicoloDto veicoloDto){
        Veicolo v = veicoloMapper.fromDtoToEntity(veicoloDto);
        veicoloService.saveOrUpdateVeicolo(v);
        return "redirect: ../utente/profiloSuperuser";
    }
}
