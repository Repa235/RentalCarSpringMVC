package com.example.rentalcarspringmvc.controller;

import com.example.rentalcarspringmvc.dto.PrenotazioneDto;
import com.example.rentalcarspringmvc.entities.Prenotazione;
import com.example.rentalcarspringmvc.entities.Utente;
import com.example.rentalcarspringmvc.entities.Veicolo;
import com.example.rentalcarspringmvc.exception.DataParseException;
import com.example.rentalcarspringmvc.mapper.PrenotazioneMapper;
import com.example.rentalcarspringmvc.service.PrenotazioneService;
import com.example.rentalcarspringmvc.service.UtenteService;
import com.example.rentalcarspringmvc.service.VeicoloService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import static com.example.rentalcarspringmvc.util.MetodiUtil.getUserFromSession;
import static com.example.rentalcarspringmvc.util.MetodiUtil.parseDate;
import static java.time.temporal.ChronoUnit.DAYS;

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
    public String dateSelector(HttpServletRequest request, @RequestParam("prenId") String prenId) {
        if (!prenId.equals("new")) {
            Prenotazione prenotazione = prenotazioneService.getPrenotazione(Long.parseLong(prenId));
            LocalDate oggi = LocalDate.now();
            if (DAYS.between(oggi, prenotazione.getDataInizio()) >= 2) {
                return "twoDays";
            } else request.setAttribute("prenotazione", prenotazione);
        }
        String username = getUserFromSession();
        Utente u = utenteService.getUsersByUsername(username);
        Utente customer = utenteService.getUtente(u.getId());
        request.setAttribute("customer", customer);
        return "dateSelector";
    }

    @GetMapping("/eliminaPrenotazione")
    public String eliminaPrenotazione(HttpServletRequest request, @RequestParam("prenId") String prenId) {

        LocalDate oggi = LocalDate.now();
        Prenotazione prenotazione = prenotazioneService.getPrenotazione(Long.parseLong(prenId));
        if (DAYS.between(oggi, prenotazione.getDataInizio()) >= 2) {
            return "twoDays";
        } else {
            prenotazioneService.deletePrenotazione(Long.parseLong(prenId));
        }
        return "redirect:/utente/profiloCustomer";
    }

    @RequestMapping(value = "/selectVeicoloByDates", method = RequestMethod.POST)
    public String selectVeicoloByDates(Model model, final HttpServletRequest request) {
        String username = getUserFromSession();
        Utente u = utenteService.getUsersByUsername(username);
        Utente customer = utenteService.getUtente(u.getId());
        model.addAttribute("customer", customer);

        LocalDate dal = parseDate(request.getParameter("dal"));
        LocalDate al = parseDate(request.getParameter("al"));

        if (dal.isAfter(al)) {
            return "fineAfterInizio";
        } else {
            String prenId = request.getParameter("prenId");
            // Se l'id della prenotazione esiste vuol dire che la prenotazione è da modificare, pertanto la prenotazione
            //verrà eliminata per ri-verificare la disponibilità del veicolo
            if (!prenId.isEmpty()) {
                Prenotazione prenotazione = prenotazioneService.getPrenotazione(Long.parseLong(prenId));
                prenotazioneService.deletePrenotazione(prenotazione.getId());
            }
            model.addAttribute("dal", dal);
            model.addAttribute("al", al);
            List<Veicolo> lv = veicoloService.getVeicoliLiberiNelRange(dal, al);
            model.addAttribute("lv", lv);
            PrenotazioneDto newPrenotazioneDto = new PrenotazioneDto();
            model.addAttribute("newPrenotazioneDto", newPrenotazioneDto);
            return "formPrenotazione";
        }
    }


    @ExceptionHandler(DataParseException.class)
    public ModelAndView handleError(HttpServletRequest request, DataParseException exception) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("data", exception.getDataIoF());
        mav.addObject("exception", exception);
        mav.addObject("url", request.getRequestURL() + "?" + request.getQueryString());
        mav.setViewName("NoDataParse");
        return mav;
    }


    @PostMapping(value = "/inserisciPrenotazione")
    public String inserisciPrenotazione(@Valid @ModelAttribute("newPrenotazioneDto") PrenotazioneDto newPrenotazioneDto, BindingResult result) {
        if (result.hasErrors()) {
            return "formPrenotazione";
        }
        prenotazioneService.saveOrUpdatePrenotazione(newPrenotazioneDto);
        return "redirect:/utente/profiloCustomer";
    }

    @GetMapping("/visualizzaPrenotazioni")
    public String visualizzaProdotti(@RequestParam("customerIdString") String customerIdString, Model model) {
        if (customerIdString.equals("") || customerIdString.isEmpty() || customerIdString.equals("all")) {
            String username = getUserFromSession();
            Utente superuser = utenteService.getUsersByUsername(username);
            model.addAttribute("superuser", superuser);
            List<Prenotazione> prenotazioni = prenotazioneService.getAllPrenotazioni();
            model.addAttribute("prenotazioni", prenotazioni);
        } else {
            Utente u = utenteService.getUsersByUsername(getUserFromSession());
            Set<Prenotazione> prenotazioni = u.getPrenotazioni();
            model.addAttribute("prenotazioni", prenotazioni);
        }
        return "visualizzaPrenotazioni";
    }


    @PostMapping("/gestisciPrenotazione")
    public String gestisciPrenotazione(@RequestParam("prenotazioneIdString") String prenotazioneIdString,
                                       @RequestParam("approva") String azione) {
        Prenotazione p = prenotazioneService.getPrenotazione(Long.parseLong(prenotazioneIdString));
        if (azione.equals("true")) {
            prenotazioneService.approvaPrenotazione(p);
        } else if (azione.equals("elimina")) {
            prenotazioneService.deletePrenotazione(p.getId());
        }
        return "redirect: visualizzaPrenotazioni?customerId=all";

    }


}



