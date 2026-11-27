package it.rotech.libreria.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class AutoreDTO {

    private Integer id;
    
    @NotBlank(message = "Il nome dell'autore è obbligatorio")
    @Size(min = 2, max = 50, message = "Il nome deve essere compreso tra 2 e 50 caratteri")
    private String nome;

    @NotBlank(message = "Il cognome dell'autore è obbligatorio")
    @Size(min = 2, max = 50, message = "Il cognome deve essere compreso tra 2 e 50 caratteri")
    private String cognome;

    @NotNull(message = "La data di nascita è obbligatoria")
    @Past(message = "La data di nascita deve essere nel passato")
    private LocalDate dataNascita;

    @NotBlank(message = "La nazionalità è obbligatoria")
    private String nazionalita;

    public AutoreDTO (){}

public AutoreDTO (String nome, String cognome, LocalDate dataNascita, String nazionalita) {
    this.nome=nome;
    this.cognome=cognome;
    this.dataNascita=dataNascita;
    this.nazionalita=nazionalita;
}

public Integer getId () {
    return id;
}

public void setId (Integer id) {
    this.id=id;
}

public String getNome () {
    return nome;
}

public void setNome (String nome) {
    this.nome=nome;
}

public String getCognome () {
    return cognome;
}

public void setCognome (String cognome){
    this.cognome=cognome;
}

public LocalDate getDataNascita () {
    return dataNascita;
}

public void setDataNascita (LocalDate dataNascita) {
    this.dataNascita=dataNascita;
}

public String getNazionalita () {
    return nazionalita;
}

public void setNazionalita (String nazionalita) {
    this.nazionalita=nazionalita;
}
}
