package it.rotech.libreria.dto.Request;

import java.time.LocalDate;

public class AutoreRequest {
    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    private String nazionalita;

    public AutoreRequest () {}

    public AutoreRequest(String nome, String cognome, LocalDate dataNascita, String nazionalita) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.nazionalita = nazionalita;
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

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getNazionalita() {
        return nazionalita;
    }

    public void setNazionalita(String nazionalita) {
        this.nazionalita = nazionalita;
    }

    
}
