package com.example.rentalcarspringmvc.controller;

import com.example.rentalcarspringmvc.dto.VeicoloDto;
import com.example.rentalcarspringmvc.entities.Veicolo;
import com.example.rentalcarspringmvc.mapper.VeicoloMapper;
import com.example.rentalcarspringmvc.service.VeicoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/veicolo")
public class VeicoloController {

    @Autowired
    private VeicoloService veicoloService;

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
        model.addAttribute("veicoloDto", new VeicoloDto());
        return "formVeicolo";
    }
    @GetMapping("/aggiungiVeicolo")
    public String aggiungiVeicolo(@ModelAttribute("veicoloDto") VeicoloDto veicoloDto){
        Veicolo v = VeicoloMapper.fromDtoToEntityAdd(veicoloDto);
        veicoloService.saveOrUpdateVeicolo(v);
        return "redirect:/utente";
    }
}
