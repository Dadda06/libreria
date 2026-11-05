package it.rotech.libreria.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table (name="Autori")

public class Autore {
@Id 
@Column (name="idAutore")
private Integer idAutore;
@Column (name="nome")
private String nome;
@Column (name="cognome")
private String cognome;
@Column (name="data_nascita")
private LocalDate data_nascita;
@Column (name="nazionalita")
private String nazionalita;



}
