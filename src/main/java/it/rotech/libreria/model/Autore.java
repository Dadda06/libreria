package it.rotech.libreria.model;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity 
@Table (name="Autori")

public class Autore {
@Id 
@GeneratedValue (strategy = GenerationType.IDENTITY)
@Column (name="idAutore")
private Integer idAutore;
@Column (name="nome")
private String nome;
@Column (name="cognome")
private String cognome;
@Column (name="data_nascita")
private LocalDate dataNascita;
@Column (name="nazionalita")
private String nazionalita;
@ManyToMany 
@JoinTable (
    name = "Libri_Autori",
    joinColumns = @JoinColumn (name = "fk_libro"),
    inverseJoinColumns = @JoinColumn (name= "fk_autore")
)
private Set<Libro> libro;

public Autore (){}

public Autore (String nome, String cognome, LocalDate dataNascita, String nazionalita) {
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
