package com.example.rentalcarspringmvc.service;

import com.example.rentalcarspringmvc.entities.Veicolo;

import java.time.LocalDate;
import java.util.List;

public interface VeicoloService {
    public Veicolo getVeicolo(Long id);
    public List<Veicolo> getVeicoli();
    public boolean saveOrUpdateVeicolo(Veicolo c);
    public boolean deleteVeicolo(Veicolo c);
    public List<Veicolo> getVeicoliLiberiNelRange(LocalDate dataSceltaI, LocalDate dataSceltaF);
}
