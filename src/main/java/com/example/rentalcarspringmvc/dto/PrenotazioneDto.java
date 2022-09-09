package com.example.rentalcarspringmvc.dto;


import javax.validation.constraints.NotEmpty;

public class PrenotazioneDto {

    private String id;
    private String idUtente;
    private String idVeicolo;
@NotEmpty(message = "La data di inizio non pùò essere nulla")
    private String dataInizio;
    @NotEmpty(message = "La data di fine non può essere nulla")
private String dataFine;
    private String isApprovato;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(String idUtente) {
        this.idUtente = idUtente;
    }

    public String getIdVeicolo() {
        return idVeicolo;
    }

    public void setIdVeicolo(String idVeicolo) {
        this.idVeicolo = idVeicolo;
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
