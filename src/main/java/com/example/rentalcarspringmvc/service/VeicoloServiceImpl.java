package com.example.rentalcarspringmvc.service;

import com.example.rentalcarspringmvc.entities.Veicolo;
import com.example.rentalcarspringmvc.repository.VeicoloDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class VeicoloServiceImpl implements VeicoloService{
    @Autowired
    VeicoloDao veicoloDao;

    @Override
    public Veicolo getVeicolo(Long id) {
        return veicoloDao.getVeicolo(id);
    }

    @Override
    public List<Veicolo> getVeicoli() {
        return veicoloDao.getVeicoli();
    }

    @Override
    public boolean saveOrUpdateVeicolo(Veicolo c) {
        return veicoloDao.saveOrUpdateVeicolo(c);
    }

    @Override
    public boolean deleteVeicolo(Veicolo c) {
        return veicoloDao.deleteVeicolo(c);
    }

    @Override
    public List<Veicolo> getVeicoliLiberiNelRange(LocalDate dataSceltaI, LocalDate dataSceltaF) {
        return veicoloDao.getVeicoliLiberiNelRange(dataSceltaI,dataSceltaF);
    }
}
