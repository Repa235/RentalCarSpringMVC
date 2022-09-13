package com.example.rentalcarspringmvc.mapper;


import com.example.rentalcarspringmvc.dto.VeicoloDto;
import com.example.rentalcarspringmvc.entities.Veicolo;
import com.example.rentalcarspringmvc.repository.VeicoloDao;
import com.example.rentalcarspringmvc.repository.VeicoloDaoImpl;

public class VeicoloMapper {
    private static VeicoloDao veicolodao = new VeicoloDaoImpl();

    public VeicoloMapper(VeicoloDao veicolodao) {
        this.veicolodao = veicolodao;
    }

    public static Veicolo fromDtoToEntity(VeicoloDto veicoloDto) {
        if (!veicoloDto.getId().isEmpty()) {
            Veicolo v = veicolodao.getVeicolo(Long.parseLong(veicoloDto.getId()));
            return new Veicolo(
                    Long.parseLong(veicoloDto.getId()),
                    veicoloDto.getCasaCostruttrice(),
                    veicoloDto.getModello(),
                    Integer.parseInt(veicoloDto.getAnnoImmatricolazione()),
                    veicoloDto.getTipo(),
                    v.getPrenotazioni()
            );
        } else {
            return new Veicolo(
                    veicoloDto.getCasaCostruttrice(),
                    veicoloDto.getModello(),
                    Integer.parseInt(veicoloDto.getAnnoImmatricolazione()),
                    veicoloDto.getTipo()
            );
        }
    }
}

