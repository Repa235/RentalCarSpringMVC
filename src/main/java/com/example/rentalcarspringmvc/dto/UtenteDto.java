package com.example.rentalcarspringmvc.dto;


import javax.validation.constraints.NotEmpty;

public class UtenteDto {



   private Long id;
   @NotEmpty(message="Il NOME non può essere nullo")
   private String nome;
   @NotEmpty(message="Il COGNOME non può essere nullo")
   private String cognome;
   @NotEmpty(message="La DATA DI NASCITA non può essere nulla")
   private String dataNascita;
   private String tipo;
   @NotEmpty(message="Inserire USERNAME")
   private String username;
   @NotEmpty(message="inserire PASSWORD")
   private String password;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
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
