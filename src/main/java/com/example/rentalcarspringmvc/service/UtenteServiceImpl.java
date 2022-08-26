package com.example.rentalcarspringmvc.service;

import com.example.rentalcarspringmvc.entities.Utente;
import com.example.rentalcarspringmvc.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("utenteService")
@Transactional
public class UtenteServiceImpl implements UtenteService{

    @Autowired
    UtenteRepository utenteRepository;

    @Override
    public Utente getUtente(Long id) {
        return utenteRepository.getUtente(id);
    }

    @Override
    public boolean saveOrUpdateUtente(Utente c) {
        return utenteRepository.saveOrUpdateUtente(c);
    }

    @Override
    public boolean deleteUtente(Utente c) {
        return deleteUtente(c);
    }

    @Override
    public List<Utente> getCustomers() {
        return utenteRepository.getCustomers();
    }

    @Override
    public List<Utente> getUsersByUsername(String username) {
        return utenteRepository.getUsersByUsername(username);
    }

    @Override
    public List<Utente> getCustomerByParam(String filtro, String testo) {
        return getCustomerByParam(filtro,testo);
    }
}
