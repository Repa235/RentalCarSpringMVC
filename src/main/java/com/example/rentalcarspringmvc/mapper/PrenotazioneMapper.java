package com.example.rentalcarspringmvc.mapper;

import com.example.rentalcarspringmvc.dto.PrenotazioneDto;
import com.example.rentalcarspringmvc.entities.Prenotazione;
import com.example.rentalcarspringmvc.entities.Utente;
import com.example.rentalcarspringmvc.entities.Veicolo;
import com.example.rentalcarspringmvc.repository.UtenteDao;
import com.example.rentalcarspringmvc.repository.UtenteDaoImpl;
import com.example.rentalcarspringmvc.repository.VeicoloDao;
import com.example.rentalcarspringmvc.repository.VeicoloDaoImpl;

import java.time.LocalDate;

public class PrenotazioneMapper {

    public static Prenotazione fromDtoToEntityModify(PrenotazioneDto prenotazioneDto) {
        UtenteDao ud = new UtenteDaoImpl();
        VeicoloDao vd = new VeicoloDaoImpl();

        Utente u = ud.getUtente(Long.parseLong(prenotazioneDto.getIdUtente()));
        Veicolo v = vd.getVeicolo(Long.parseLong(prenotazioneDto.getIdVeicolo()));
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
        UtenteDao ud = new UtenteDaoImpl();
        VeicoloDao vd = new VeicoloDaoImpl();

        Utente u = ud.getUtente(Long.parseLong(prenotazioneDto.getIdUtente()));
        Veicolo v = vd.getVeicolo(Long.parseLong(prenotazioneDto.getIdVeicolo()));
        return new Prenotazione(
                u,
                v,
                LocalDate.parse(prenotazioneDto.getDataInizio()),
                LocalDate.parse(prenotazioneDto.getDataFine()),
                Boolean.parseBoolean(prenotazioneDto.getIsApprovato())
        );
    }
}
