package it.rotech.libreria.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity 
@Table (name = "Generi")
public class Genere {

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idGenere")
    private Integer idGenere;
    @Column (name="nome")
    private String nome;
    @OneToMany(mappedBy = "genere")
    private Set<Libro> Libri=new HashSet<>(); 

    public Genere () {}

    public Genere (String nome) {
        this.nome=nome;
    }

    public Integer getIdGenere () {
        return idGenere;
    }

    public void setIdGenere (Integer idGenere) {
        this.idGenere=idGenere;
    }

    public String getNome () {
        return nome;
    }

    public void setNome (String nome) {
        this.nome=nome;
    }

    public Set<Libro> getLibri () {
        return Libri;
    } 

    public void setLibri (Set<Libro> Libri) {
        this.Libri=Libri;
    }
}