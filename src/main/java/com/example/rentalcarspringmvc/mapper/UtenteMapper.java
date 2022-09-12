package com.example.rentalcarspringmvc.mapper;

import com.example.rentalcarspringmvc.dto.PrenotazioneDto;
import com.example.rentalcarspringmvc.dto.UtenteDto;
import com.example.rentalcarspringmvc.entities.Utente;
import com.example.rentalcarspringmvc.entities.Utente;
import com.example.rentalcarspringmvc.entities.Veicolo;
import com.example.rentalcarspringmvc.repository.UtenteDao;
import com.example.rentalcarspringmvc.repository.UtenteDaoImpl;
import com.example.rentalcarspringmvc.repository.VeicoloDao;
import com.example.rentalcarspringmvc.repository.VeicoloDaoImpl;
import com.example.rentalcarspringmvc.service.UtenteService;
import com.example.rentalcarspringmvc.service.VeicoloService;

import java.time.LocalDate;

public class UtenteMapper {

    private static UtenteService utenteService;

    public UtenteMapper(UtenteService utenteService) {
        this.utenteService = utenteService;
    }

    public static Utente fromDtoToEntityModify(UtenteDto utenteDto) {
        Utente u = utenteService.getUtente(Long.parseLong(utenteDto.getId()));
        return new Utente(
                Long.parseLong(utenteDto.getId()),
                utenteDto.getNome(),
                utenteDto.getCognome(),
                LocalDate.parse(utenteDto.getDataNascita()),
                utenteDto.getTipo(),
                utenteDto.getUsername(),
                utenteDto.getPassword(),
                u.getPrenotazioni()
        );
    }

    public static Utente fromDtoToEntityAdd(UtenteDto utenteDto) {
        return new Utente(
                utenteDto.getNome(),
                utenteDto.getCognome(),
                LocalDate.parse(utenteDto.getDataNascita()),
                utenteDto.getTipo(),
                utenteDto.getUsername(),
                utenteDto.getPassword(),
                null
        );
    }

}

