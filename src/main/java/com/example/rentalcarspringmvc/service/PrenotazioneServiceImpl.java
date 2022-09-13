package com.example.rentalcarspringmvc.service;

import com.example.rentalcarspringmvc.dto.PrenotazioneDto;
import com.example.rentalcarspringmvc.entities.Prenotazione;
import com.example.rentalcarspringmvc.entities.Utente;
import com.example.rentalcarspringmvc.entities.Veicolo;
import com.example.rentalcarspringmvc.mapper.PrenotazioneMapper;
import com.example.rentalcarspringmvc.repository.PrenotazioneDao;
import com.example.rentalcarspringmvc.repository.UtenteDao;
import com.example.rentalcarspringmvc.repository.VeicoloDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrenotazioneServiceImpl implements PrenotazioneService {

    private final
    PrenotazioneDao prenotazioneDao;

    private final UtenteDao utenteDao;
    private final VeicoloDao veicoloDao;

    public PrenotazioneServiceImpl(PrenotazioneDao prenotazioneDao, UtenteDao utenteDao, VeicoloDao veicoloDao) {
        this.prenotazioneDao = prenotazioneDao;
        this.utenteDao = utenteDao;
        this.veicoloDao = veicoloDao;
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
    public void saveOrUpdatePrenotazione(PrenotazioneDto prenotazioneDto) {
        Veicolo v = veicoloDao.getVeicolo(prenotazioneDto.getIdVeicolo());
        Utente u = utenteDao.getUtente(prenotazioneDto.getIdUtente());
        Prenotazione p = prenotazioneDto.getId()==null?
                new Prenotazione() : prenotazioneDao.getPrenotazione(prenotazioneDto.getId());
        PrenotazioneMapper.fromDtoToEntity(prenotazioneDto,u,v,p);
        prenotazioneDao.saveOrUpdatePrenotazione(p);
    }

    @Override
    public boolean deletePrenotazione(Long id) {
        Prenotazione c = getPrenotazione(id);
        return prenotazioneDao.deletePrenotazione(c);

    }

    @Override
    public void approvaPrenotazione(Prenotazione p) {
        p.setApprovato(true);
        prenotazioneDao.saveOrUpdatePrenotazione(p);
    }
}
