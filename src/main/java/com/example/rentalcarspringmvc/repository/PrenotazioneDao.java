package com.example.rentalcarspringmvc.repository;

import com.example.rentalcarspringmvc.entities.Prenotazione;

import java.util.List;

public interface PrenotazioneDao {
    Prenotazione getPrenotazione(Long id);
    List<Prenotazione> getAllPrenotazioni();
    boolean saveOrUpdatePrenotazione(Prenotazione c);
    boolean deletePrenotazione(Prenotazione c);

}
