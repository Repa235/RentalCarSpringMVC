package com.example.rentalcarspringmvc.repository;

import com.example.rentalcarspringmvc.entities.Utente;

import java.util.List;

public interface UtenteDao {
    Utente getUtente(Long id);
    boolean saveOrUpdateUtente(Utente c);
    boolean deleteUtente(Utente c);
    List<Utente> getCustomers();
    Utente getUsersByUsername(String username);
    List<Utente> getCustomerByParam(String filtro, String testo);
}
