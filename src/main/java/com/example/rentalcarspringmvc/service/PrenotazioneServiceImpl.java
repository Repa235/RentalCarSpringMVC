package com.example.rentalcarspringmvc.service;

import com.example.rentalcarspringmvc.entities.Prenotazione;
import com.example.rentalcarspringmvc.repository.PrenotazioneDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PrenotazioneServiceImpl implements PrenotazioneService{

    @Autowired
    PrenotazioneDao prenotazioneDao;

    @Override
    public Prenotazione getPrenotazione(Long id) {
        return prenotazioneDao.getPrenotazione(id);
    }

    @Override
    public List<Prenotazione> getAllPrenotazioni() {
        return prenotazioneDao.getAllPrenotazioni();
    }

    @Override
    public boolean saveOrUpdatePrenotazione(Prenotazione c) {
        return prenotazioneDao.saveOrUpdatePrenotazione(c);
    }

    @Override
    public boolean deletePrenotazione(Prenotazione c) {
        return prenotazioneDao.deletePrenotazione(c);
    }
}
