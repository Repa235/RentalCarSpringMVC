package com.example.rentalcarspringmvc.controller;

import com.example.rentalcarspringmvc.dto.PrenotazioneDto;
import com.example.rentalcarspringmvc.entities.Prenotazione;
import com.example.rentalcarspringmvc.entities.Veicolo;
import com.example.rentalcarspringmvc.mapper.PrenotazioneMapper;
import com.example.rentalcarspringmvc.service.PrenotazioneService;
import com.example.rentalcarspringmvc.service.UtenteService;
import com.example.rentalcarspringmvc.service.VeicoloService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/prenotazione")
public class PrenotazioneController {

    private final UtenteService utenteService;
    private final VeicoloService veicoloService;
    private final PrenotazioneService prenotazioneService;

    public PrenotazioneController(UtenteService utenteService, VeicoloService veicoloService, PrenotazioneService prenotazioneService) {
        this.utenteService = utenteService;
        this.veicoloService = veicoloService;
        this.prenotazioneService = prenotazioneService;
    }

    @GetMapping("/dateSelector")
    public String dateSelector() {
        return "dateSelector";
    }

    @RequestMapping(value = "/selectVeicoloByDates", method = RequestMethod.POST)
    public String selectVeicoloByDates(Model model, final HttpServletRequest request) {
        LocalDate dal = LocalDate.parse(request.getParameter("dal"));
        LocalDate al = LocalDate.parse(request.getParameter("al"));
        model.addAttribute("dal", dal);
        model.addAttribute("al", al);
        List<Veicolo> lv = veicoloService.getVeicoliLiberiNelRange(dal, al);
        model.addAttribute("lv", lv);
        PrenotazioneDto newPrenotazioneDto = new PrenotazioneDto();
        model.addAttribute("newPrenotazioneDto", newPrenotazioneDto);
        return "formPrenotazione";
    }


    @PostMapping(value = "/inserisciPrenotazione")
    public String inserisciPrenotazione(@Valid @ModelAttribute("newPrenotazioneDto") PrenotazioneDto newPrenotazioneDto, BindingResult result) {
        if (result.hasErrors()) {
            return "formPrenotazione";
        }
        Prenotazione p = PrenotazioneMapper.fromDtoToEntityAdd(newPrenotazioneDto);
        prenotazioneService.saveOrUpdatePrenotazione(p);
        return "redirect:/utente/profiloCustomer";
    }


}
