package com.example.rentalcarspringmvc.mapper;

import com.example.rentalcarspringmvc.dto.PrenotazioneDto;
import com.example.rentalcarspringmvc.entities.Prenotazione;
import com.example.rentalcarspringmvc.entities.Utente;
import com.example.rentalcarspringmvc.entities.Veicolo;
import com.example.rentalcarspringmvc.service.UtenteService;
import com.example.rentalcarspringmvc.service.VeicoloService;

import java.time.LocalDate;

public class PrenotazioneMapper {

    private static VeicoloService veicoloService;
    private static UtenteService utenteService;

    public PrenotazioneMapper(VeicoloService veicoloService, UtenteService utenteService) {
        this.veicoloService = veicoloService;
        this.utenteService = utenteService;
    }


    public static Prenotazione fromDtoToEntityModify(PrenotazioneDto prenotazioneDto) {
        Utente u = utenteService.getUtente(Long.parseLong(prenotazioneDto.getIdUtente()));
        Veicolo v = veicoloService.getVeicolo(Long.parseLong(prenotazioneDto.getIdVeicolo()));
        return new Prenotazione(
                Long.parseLong(prenotazioneDto.getId()),
                u,
                v,
                LocalDate.parse(prenotazioneDto.getDataInizio()),
                LocalDate.parse(prenotazioneDto.getDataFine()),
                Boolean.parseBoolean(prenotazioneDto.getIsApprovato())
        );
    }

    public static Prenotazione fromDtoToEntityAdd(PrenotazioneDto prenotazioneDto) {
        Utente u = utenteService.getUtente(Long.parseLong(prenotazioneDto.getIdUtente()));
        Veicolo v = veicoloService.getVeicolo(Long.parseLong(prenotazioneDto.getIdVeicolo()));
        return new Prenotazione(
                u,
                v,
                LocalDate.parse(prenotazioneDto.getDataInizio()),
                LocalDate.parse(prenotazioneDto.getDataFine()),
                Boolean.parseBoolean(prenotazioneDto.getIsApprovato())
        );
    }
}
