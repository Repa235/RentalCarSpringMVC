package com.example.rentalcarspringmvc.mapper;

import com.example.rentalcarspringmvc.dto.PrenotazioneDto;
import com.example.rentalcarspringmvc.entities.Prenotazione;
import com.example.rentalcarspringmvc.entities.Utente;
import com.example.rentalcarspringmvc.entities.Veicolo;
import com.example.rentalcarspringmvc.repository.UtenteDao;
import com.example.rentalcarspringmvc.repository.UtenteDaoImpl;
import com.example.rentalcarspringmvc.repository.VeicoloDao;
import com.example.rentalcarspringmvc.repository.VeicoloDaoImpl;


import java.time.LocalDate;

public class PrenotazioneMapper {

    private static VeicoloDao veicolodao = new VeicoloDaoImpl();
    private static UtenteDao utentedao = new UtenteDaoImpl();

    public PrenotazioneMapper(VeicoloDao veicolodao, UtenteDao utentedao) {
        this.veicolodao = veicolodao;
        this.utentedao = utentedao;
    }


    public static Prenotazione fromDtoToEntity(PrenotazioneDto prenotazioneDto) {
        if (!prenotazioneDto.getId().isEmpty()) {
            Utente u = utentedao.getUtente(Long.parseLong(prenotazioneDto.getIdUtente()));
            Veicolo v = veicolodao.getVeicolo(Long.parseLong(prenotazioneDto.getIdVeicolo()));
            return new Prenotazione(
                    Long.parseLong(prenotazioneDto.getId()),
                    u,
                    v,
                    LocalDate.parse(prenotazioneDto.getDataInizio()),
                    LocalDate.parse(prenotazioneDto.getDataFine()),
                    Boolean.parseBoolean(prenotazioneDto.getIsApprovato())
            );
        } else {
            Utente u = utentedao.getUtente(Long.parseLong(prenotazioneDto.getIdUtente()));
            Veicolo v = veicolodao.getVeicolo(Long.parseLong(prenotazioneDto.getIdVeicolo()));
            return new Prenotazione(
                    u,
                    v,
                    LocalDate.parse(prenotazioneDto.getDataInizio()),
                    LocalDate.parse(prenotazioneDto.getDataFine()),
                    Boolean.parseBoolean(prenotazioneDto.getIsApprovato())
            );
        }
    }
}
