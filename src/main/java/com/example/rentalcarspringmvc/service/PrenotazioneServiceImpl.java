package com.example.rentalcarspringmvc.service;

import com.example.rentalcarspringmvc.entities.Prenotazione;
import com.example.rentalcarspringmvc.repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PrenotazioneServiceImpl implements PrenotazioneService{

    @Autowired
    PrenotazioneRepository prenotazioneRepository;

    @Override
    public Prenotazione getPrenotazione(Long id) {
        return prenotazioneRepository.getPrenotazione(id);
    }

    @Override
    public List<Prenotazione> getAllPrenotazioni() {
        return prenotazioneRepository.getAllPrenotazioni();
    }

    @Override
    public boolean saveOrUpdatePrenotazione(Prenotazione c) {
        return prenotazioneRepository.saveOrUpdatePrenotazione(c);
    }

    @Override
    public boolean deletePrenotazione(Prenotazione c) {
        return prenotazioneRepository.deletePrenotazione(c);
    }
}
