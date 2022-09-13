package com.example.rentalcarspringmvc.mapper;

import com.example.rentalcarspringmvc.dto.UtenteDto;
import com.example.rentalcarspringmvc.entities.Utente;
import com.example.rentalcarspringmvc.repository.UtenteDao;
import com.example.rentalcarspringmvc.repository.UtenteDaoImpl;

import java.time.LocalDate;

public class UtenteMapper {

    private static UtenteDao utentedao = new UtenteDaoImpl();

    public UtenteMapper(UtenteDao utentedao) {this.utentedao=utentedao;
    }

    public static Utente fromDtoToEntity(UtenteDto utenteDto) {
        if(!utenteDto.getId().isEmpty()){
        Utente u = utentedao.getUtente(Long.parseLong(utenteDto.getId()));
        return new Utente(
                Long.parseLong(utenteDto.getId()),
                utenteDto.getNome(),
                utenteDto.getCognome(),
                LocalDate.parse(utenteDto.getDataNascita()),
                utenteDto.getTipo(),
                utenteDto.getUsername(),
                utenteDto.getPassword(),
                u.getPrenotazioni()
        );
        } else {
            return new Utente(
                    utenteDto.getNome(),
                    utenteDto.getCognome(),
                    LocalDate.parse(utenteDto.getDataNascita()),
                    utenteDto.getTipo(),
                    utenteDto.getUsername(),
                    utenteDto.getPassword(),
                    null);
        }

    }
}

