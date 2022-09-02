package com.example.rentalcarspringmvc.dto;


import javax.validation.constraints.NotEmpty;

public class UtenteDto {



   private String id;
   @NotEmpty(message="{errore.formutente.nome.nullo}")
   private String nome;
   @NotEmpty(message="{errore.formutente.cognome.nullo}")
   private String cognome;
   @NotEmpty(message="{errore.formutente.datanascita.nullo}")
   private String dataNascita;
   private String tipo;
   @NotEmpty(message="{errore.formutente.username.nullo}")
   private String username;
   @NotEmpty(message="{errore.formutente.password.nullo}")
   private String password;

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getNome() {
      return nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public String getCognome() {
      return cognome;
   }

   public void setCognome(String cognome) {
      this.cognome = cognome;
   }

   public String getDataNascita() {
      return dataNascita;
   }

   public void setDataNascita(String dataNascita) {
      this.dataNascita = dataNascita;
   }

   public String getTipo() {
      return tipo;
   }

   public void setTipo(String tipo) {
      this.tipo = tipo;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }
}
