package it.rotech.libreria.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity 
@Table (name = "Generi")
public class Genere {

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idGenere")
    private Integer id;
    @Column (name="nome")
    private String nome;

    public Genere () {}

    public Genere (String nome) {
        this.nome=nome;
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

}