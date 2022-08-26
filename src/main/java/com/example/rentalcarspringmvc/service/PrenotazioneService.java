package com.example.rentalcarspringmvc.service;

import com.example.rentalcarspringmvc.entities.Prenotazione;

import java.util.List;

public interface PrenotazioneService {
    public Prenotazione getPrenotazione(Long id);
    public List<Prenotazione> getAllPrenotazioni();
    public boolean saveOrUpdatePrenotazione(Prenotazione c);
    public boolean deletePrenotazione(Prenotazione c);
}
