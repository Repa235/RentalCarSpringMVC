package com.example.rentalcarspringmvc.mapper;

import com.example.rentalcarspringmvc.dto.UtenteDto;
import com.example.rentalcarspringmvc.entities.Utente;
import com.example.rentalcarspringmvc.repository.UtenteDao;
import com.example.rentalcarspringmvc.repository.UtenteDaoImpl;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
@Component
public class UtenteMapper {

    private static UtenteDao utentedao;
    public UtenteMapper(UtenteDao utentedao) {this.utentedao=utentedao;
    }

    public static void fromDtoToEntity(UtenteDto utenteDto) {
        Utente u = utentedao.getUtente(utenteDto.getId());
u.setUsername(utenteDto.getUsername());
u.setCognome(utenteDto.getCognome());
u.setDataNascita(LocalDate.parse(utenteDto.getDataNascita()));
u.setNome(utenteDto.getNome());
u.setPassword(utenteDto.getPassword());
    }
}

