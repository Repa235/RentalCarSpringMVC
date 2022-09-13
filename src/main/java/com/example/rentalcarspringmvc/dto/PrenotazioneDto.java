package com.example.rentalcarspringmvc.dto;


import javax.validation.constraints.NotEmpty;

public class PrenotazioneDto {

    private Long id;
    private Long idUtente;
    private Long idVeicolo;
@NotEmpty(message = "La data di inizio non pùò essere nulla")
    private String dataInizio;
    @NotEmpty(message = "La data di fine non può essere nulla")
private String dataFine;
    private Boolean isApprovato;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(Long idUtente) {
        this.idUtente = idUtente;
    }

    public Long getIdVeicolo() {
        return idVeicolo;
    }

    public void setIdVeicolo(Long idVeicolo) {
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

    public boolean getIsApprovato() {
        return isApprovato;
    }

    public void setIsApprovato(Boolean isApprovato) {
        this.isApprovato = isApprovato;
    }
}
