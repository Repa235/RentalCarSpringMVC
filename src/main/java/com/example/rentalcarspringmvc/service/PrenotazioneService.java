package com.example.rentalcarspringmvc.service;

import com.example.rentalcarspringmvc.dto.PrenotazioneDto;
import com.example.rentalcarspringmvc.entities.Prenotazione;

import java.util.List;

public interface PrenotazioneService {
    Prenotazione getPrenotazione(Long id);

    List<Prenotazione> getAllPrenotazioni();

    void saveOrUpdatePrenotazione(PrenotazioneDto pdto);

    boolean deletePrenotazione(Long id);

    void approvaPrenotazione(Prenotazione p);
}
