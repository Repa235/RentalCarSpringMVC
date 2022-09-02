package com.example.rentalcarspringmvc.mapper;

import com.example.rentalcarspringmvc.dto.PrenotazioneDto;
import com.example.rentalcarspringmvc.dto.UtenteDto;
import com.example.rentalcarspringmvc.dto.VeicoloDto;
import com.example.rentalcarspringmvc.entities.Prenotazione;
import com.example.rentalcarspringmvc.entities.Utente;
import com.example.rentalcarspringmvc.entities.Veicolo;
import com.example.rentalcarspringmvc.repository.UtenteDao;
import com.example.rentalcarspringmvc.repository.UtenteDaoImpl;
import com.example.rentalcarspringmvc.repository.VeicoloDao;
import com.example.rentalcarspringmvc.repository.VeicoloDaoImpl;

import java.time.LocalDate;

public class VeicoloMapper {

    public static Veicolo fromDtoToEntityModify(VeicoloDto veicoloDto) {
        VeicoloDao vd = new VeicoloDaoImpl();
        Veicolo v = vd.getVeicolo(Long.parseLong(veicoloDto.getId()));
        return new Veicolo(
                Long.parseLong(veicoloDto.getId()),
                veicoloDto.getCasaCostruttrice(),
                veicoloDto.getModello(),
                Integer.parseInt(veicoloDto.getAnnoImmatricolazione()),
                veicoloDto.getTipo(),
                null
        );
    }

    public static Veicolo fromDtoToEntityAdd(VeicoloDto veicoloDto) {
        VeicoloDao vd = new VeicoloDaoImpl();
        Veicolo v = vd.getVeicolo(Long.parseLong(veicoloDto.getId()));
        return new Veicolo(
                veicoloDto.getCasaCostruttrice(),
                veicoloDto.getModello(),
                Integer.parseInt(veicoloDto.getAnnoImmatricolazione()),
                veicoloDto.getTipo()
        );
    }

}

