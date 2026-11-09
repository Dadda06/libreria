package it.rotech.libreria.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table (name = "Casa_Editrice")

public class CasaEditrice {  
@Id 
@GeneratedValue (strategy = GenerationType.IDENTITY)
@Column (name = "idCasa")
private Integer id;
@Column (name = "nome")
private String nome;


public CasaEditrice () {}

public CasaEditrice (String nome) {
    this.nome=nome;
}

public Integer getId () {
    return id;
}

public String getNome () {
    return nome;
}

public void setNome (String nome) {
    this.nome=nome;
}



}
