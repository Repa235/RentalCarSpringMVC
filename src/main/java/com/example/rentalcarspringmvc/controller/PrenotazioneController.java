package com.example.rentalcarspringmvc.controller;

import com.example.rentalcarspringmvc.dto.PrenotazioneDto;
import com.example.rentalcarspringmvc.entities.Prenotazione;
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
        String dalS = request.getParameter("dal");
        String alS = request.getParameter("al");
        if (dalS == null || dalS.isEmpty()) {
            throw new DataParseException(dalS);
        } else if (alS == null || alS.isEmpty()) {
            throw new DataParseException(alS);
        } else {
            LocalDate dal = LocalDate.parse(dalS);
            LocalDate al = LocalDate.parse(alS);
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
        Prenotazione p = PrenotazioneMapper.fromDtoToEntityAdd(newPrenotazioneDto);
        prenotazioneService.saveOrUpdatePrenotazione(p);
        return "redirect:/utente/profiloCustomer";
    }


}
