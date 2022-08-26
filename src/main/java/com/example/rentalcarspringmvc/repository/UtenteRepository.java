package com.example.rentalcarspringmvc.repository;

import com.example.rentalcarspringmvc.entities.Utente;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UtenteRepository {
    public Utente getUtente(Long id);
    public boolean saveOrUpdateUtente(Utente c);
    public boolean deleteUtente(Utente c);
    public List<Utente> getCustomers();
    public List<Utente> getUsersByUsername(String username);
    public List<Utente> getCustomerByParam(String filtro, String testo);
}
