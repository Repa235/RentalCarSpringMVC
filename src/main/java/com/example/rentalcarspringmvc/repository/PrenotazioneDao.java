package com.example.rentalcarspringmvc.repository;

import com.example.rentalcarspringmvc.entities.Prenotazione;

import java.util.List;

public interface PrenotazioneDao {
    public Prenotazione getPrenotazione(Long id);
    public List<Prenotazione> getAllPrenotazioni();
    public boolean saveOrUpdatePrenotazione(Prenotazione c);
    public boolean deletePrenotazione(Prenotazione c);

}
