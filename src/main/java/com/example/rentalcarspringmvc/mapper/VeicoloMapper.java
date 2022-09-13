package com.example.rentalcarspringmvc.mapper;


import com.example.rentalcarspringmvc.dto.VeicoloDto;
import com.example.rentalcarspringmvc.entities.Veicolo;
import com.example.rentalcarspringmvc.repository.VeicoloDao;

import org.springframework.stereotype.Component;

@Component
public class VeicoloMapper {
    private VeicoloDao veicolodao;

    public VeicoloMapper(VeicoloDao veicolodao) {
        this.veicolodao = veicolodao;
    }

    public Veicolo fromDtoToEntity(VeicoloDto veicoloDto) {
            Veicolo v = veicolodao.getVeicolo(veicoloDto.getId());
            return new Veicolo(
                    veicoloDto.getId(),
                    veicoloDto.getCasaCostruttrice(),
                    veicoloDto.getModello(),
                    Integer.parseInt(veicoloDto.getAnnoImmatricolazione()),
                    veicoloDto.getTipo(),
                    v.getPrenotazioni()
            );
    }
}

