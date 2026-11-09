package it.rotech.libreria.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table (name="Autori")

public class Autore {
@Id 
@GeneratedValue (strategy = GenerationType.IDENTITY)
@Column (name="idAutore")
private Integer id;
@Column (name="nome")
private String nome;
@Column (name="cognome")
private String cognome;
@Column (name="data_nascita")
private LocalDate dataNascita;
@Column (name="nazionalita")
private String nazionalita;

public Autore (){}

public Autore (String nome, String cognome, LocalDate dataNascita, String nazionalita) {
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
