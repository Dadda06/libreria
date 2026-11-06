package it.rotech.libreria.dto;

import java.time.LocalDate;

public class AutoreDTO {

    private Integer idAutore;
    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    private String nazionalita;

    public AutoreDTO (){}

public AutoreDTO (Integer idAutore, String nome, String cognome, LocalDate dataNascita, String nazionalita) {
    this.idAutore=idAutore;
    this.nome=nome;
    this.cognome=cognome;
    this.dataNascita=dataNascita;
    this.nazionalita=nazionalita;
}

public Integer getIdAutore () {
    return idAutore;
}

public void setIdAutore (Integer idAutore) {
    this.idAutore=idAutore;
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
