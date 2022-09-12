package com.example.rentalcarspringmvc.service;

import com.example.rentalcarspringmvc.entities.Prenotazione;
import com.example.rentalcarspringmvc.repository.PrenotazioneDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrenotazioneServiceImpl implements PrenotazioneService {

    private final
    PrenotazioneDao prenotazioneDao;

    public PrenotazioneServiceImpl(PrenotazioneDao prenotazioneDao) {
        this.prenotazioneDao = prenotazioneDao;
    }

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
    public boolean deletePrenotazione(Long id) {
        Prenotazione c = getPrenotazione(id);
        return prenotazioneDao.deletePrenotazione(c);

    }
}
