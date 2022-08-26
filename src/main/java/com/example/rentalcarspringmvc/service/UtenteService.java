package com.example.rentalcarspringmvc.service;

import com.example.rentalcarspringmvc.entities.Utente;

import java.util.List;

public interface UtenteService {
    public Utente getUtente(Long id);
    public boolean saveOrUpdateUtente(Utente c);
    public boolean deleteUtente(Utente c);
    public List<Utente> getCustomers();
    public List<Utente> getUsersByUsername(String username);
    public List<Utente> getCustomerByParam(String filtro, String testo);
}
