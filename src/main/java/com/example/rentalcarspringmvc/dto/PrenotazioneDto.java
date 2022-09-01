package com.example.rentalcarspringmvc.dto;

import com.example.rentalcarspringmvc.entities.Utente;
import com.example.rentalcarspringmvc.entities.Veicolo;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

public class PrenotazioneDto {

    private String id;
    private String id_utente;
    private String id_veicolo;
@NotEmpty(message = "{errore.datainizio.nullo}")
    private String dataInizio;
    @NotEmpty(message = "{errore.datafine.nullo}")
private String dataFine;
    private String isApprovato;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_utente() {
        return id_utente;
    }

    public void setId_utente(String id_utente) {
        this.id_utente = id_utente;
    }

    public String getId_veicolo() {
        return id_veicolo;
    }

    public void setId_veicolo(String id_veicolo) {
        this.id_veicolo = id_veicolo;
    }

    public String getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(String dataInizio) {
        this.dataInizio = dataInizio;
    }

    public String getDataFine() {
        return dataFine;
    }

    public void setDataFine(String dataFine) {
        this.dataFine = dataFine;
    }

    public String getIsApprovato() {
        return isApprovato;
    }

    public void setIsApprovato(String isApprovato) {
        this.isApprovato = isApprovato;
    }
}
