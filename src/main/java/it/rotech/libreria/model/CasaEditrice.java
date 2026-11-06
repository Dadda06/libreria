package it.rotech.libreria.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table (name = "Casa_Editrice")

public class CasaEditrice {
@Id 
@Column (name = "idCasa")
private Integer idCasa;
@Column (name = "nome")
private String nome;


public CasaEditrice () {}

public CasaEditrice (String nome) {
    this.nome=nome;
}

public Integer getIdCasa () {
    return idCasa;
}

public void setIdCasa (Integer idCasa) {
    this.idCasa=idCasa;
}

public String getNome () {
    return nome;
}

public void setNome (String nome) {
    this.nome=nome;
}



}
