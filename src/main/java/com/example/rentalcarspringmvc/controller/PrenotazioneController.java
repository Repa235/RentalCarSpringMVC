package com.example.rentalcarspringmvc.controller;

import com.example.rentalcarspringmvc.entities.Prenotazione;
import com.example.rentalcarspringmvc.entities.Veicolo;
import com.example.rentalcarspringmvc.service.PrenotazioneService;
import com.example.rentalcarspringmvc.service.VeicoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/prenotazione")
public class PrenotazioneController {

    @Autowired
    private PrenotazioneService prenotazioneService;
    @Autowired
    private VeicoloService veicoloService;

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
        Prenotazione newPrenotazione = new Prenotazione();
        model.addAttribute("newPrenotazione", newPrenotazione);
        return "formPrenotazione";
    }


    @RequestMapping(value = "/inserisciPrenotazione", method = RequestMethod.POST)
    public String inserisciPrenotazione(@ModelAttribute("newPrenotazione") Prenotazione newPrenotazione, Model model) {
        System.out.println(newPrenotazione.getDataInizio());
        return "/utente/profiloCustomer";
    }


}
