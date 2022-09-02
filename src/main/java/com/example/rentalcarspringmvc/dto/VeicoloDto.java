package com.example.rentalcarspringmvc.dto;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

public class VeicoloDto {

   private String id;
   private String casaCostruttrice;
   private String modello;
   private String annoImmatricolazione;
   private String tipo;

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getCasaCostruttrice() {
      return casaCostruttrice;
   }

   public void setCasaCostruttrice(String casaCostruttrice) {
      this.casaCostruttrice = casaCostruttrice;
   }

   public String getModello() {
      return modello;
   }

   public void setModello(String modello) {
      this.modello = modello;
   }

   public String getAnnoImmatricolazione() {
      return annoImmatricolazione;
   }

   public void setAnnoImmatricolazione(String annoImmatricolazione) {
      this.annoImmatricolazione = annoImmatricolazione;
   }

   public String getTipo() {
      return tipo;
   }

   public void setTipo(String tipo) {
      this.tipo = tipo;
   }
}
