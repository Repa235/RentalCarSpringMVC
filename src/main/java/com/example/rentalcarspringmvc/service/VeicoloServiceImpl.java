package com.example.rentalcarspringmvc.service;

import com.example.rentalcarspringmvc.entities.Veicolo;
import com.example.rentalcarspringmvc.repository.VeicoloRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

public class VeicoloServiceImpl implements VeicoloService{
    @Autowired
    VeicoloRepository veicoloRepository;

    @Override
    public Veicolo getVeicolo(Long id) {
        return veicoloRepository.getVeicolo(id);
    }

    @Override
    public List<Veicolo> getVeicoli() {
        return veicoloRepository.getVeicoli();
    }

    @Override
    public boolean saveOrUpdateVeicolo(Veicolo c) {
        return veicoloRepository.saveOrUpdateVeicolo(c);
    }

    @Override
    public boolean deleteVeicolo(Veicolo c) {
        return veicoloRepository.deleteVeicolo(c);
    }

    @Override
    public List<Veicolo> getVeicoliLiberiNelRange(LocalDate dataSceltaI, LocalDate dataSceltaF) {
        return veicoloRepository.getVeicoliLiberiNelRange(dataSceltaI,dataSceltaF);
    }
}
