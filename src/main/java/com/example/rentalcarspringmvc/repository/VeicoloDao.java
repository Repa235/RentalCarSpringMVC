package com.example.rentalcarspringmvc.repository;

import com.example.rentalcarspringmvc.entities.Veicolo;

import java.time.LocalDate;
import java.util.List;

public interface VeicoloDao {
    Veicolo getVeicolo(Long id);
    List<Veicolo> getVeicoli();
    boolean saveOrUpdateVeicolo(Veicolo c);
    boolean deleteVeicolo(Veicolo c);
    List<Veicolo> getVeicoliLiberiNelRange(LocalDate dataSceltaI, LocalDate dataSceltaF);
}
