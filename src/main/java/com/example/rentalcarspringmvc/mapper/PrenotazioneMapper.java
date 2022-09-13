package com.example.rentalcarspringmvc.mapper;

import com.example.rentalcarspringmvc.dto.PrenotazioneDto;
import com.example.rentalcarspringmvc.entities.Prenotazione;
import com.example.rentalcarspringmvc.entities.Utente;
import com.example.rentalcarspringmvc.entities.Veicolo;



import java.time.LocalDate;

public class PrenotazioneMapper {

    public static void fromDtoToEntity(PrenotazioneDto prenotazioneDto, Utente u, Veicolo v, Prenotazione p) {
        p.setApprovato(prenotazioneDto.getIsApprovato());
        p.setDataFine(LocalDate.parse(prenotazioneDto.getDataFine()));
        p.setDataInizio(LocalDate.parse(prenotazioneDto.getDataInizio()));
        p.setUtente(u);
        p.setVeicolo(v);
    }
}
