package com.example.rentalcarspringmvc.service;

import com.example.rentalcarspringmvc.entities.Utente;
import com.example.rentalcarspringmvc.repository.UtenteDao;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("utenteService")
@Transactional
public class UtenteServiceImpl implements UtenteService{

    private final
    UtenteDao utenteDao;

    public UtenteServiceImpl(UtenteDao utenteDao) {
        this.utenteDao = utenteDao;
    }

    @Override
    public Utente getUtente(Long id) {
        return utenteDao.getUtente(id);
    }

    @Override
    public boolean saveOrUpdateUtente(Utente c) {
        return utenteDao.saveOrUpdateUtente(c);
    }

    @Override
    public boolean deleteUtente(Long id) {
        Utente c = getUtente(id);
        return utenteDao.deleteUtente(c);
    }

    @Override
    public List<Utente> getCustomers() {
        return utenteDao.getCustomers();
    }

    @Override
    public Utente getUsersByUsername(String username) {
        return utenteDao.getUsersByUsername(username);
    }

    @Override
    public List<Utente> getCustomerByParam(String filtro, String testo) {
        return utenteDao.getCustomerByParam(filtro,testo);
    }
}
