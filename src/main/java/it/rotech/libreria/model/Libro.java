package it.rotech.libreria.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table (name ="Libri")
    
public class Libro {
    @Id 
    @Column (name="idLibro")
    private Integer idLibro;
    @Column (name="titolo")
    private String titolo;
    @Column (name = "anno")
    private LocalDate anno;
    @ManyToOne
    @JoinColumn (name = "fk_genere")
    private Genere genere;


    public Libro (){}

    public Libro (String titolo, LocalDate anno, Genere genere) {
        this.titolo=titolo;
        this.anno=anno;
        this.genere=genere;
    }
    
    public Integer getIdLibro () {
        return idLibro;
    }

    public void setIdLibro(Integer idLibro){
        this.idLibro=idLibro;
    }

    public String getTitolo () {
        return titolo;
    }

    public void setTitolo (String titolo){
        this.titolo=titolo;
    }

    public LocalDate getAnno () {
        return anno;
    }

    public void setAnno (LocalDate anno) {
        this.anno=anno;
    }

    public Genere getGenere () {
        return genere;
    }

    public void setGenere (Genere genere) {
        this.genere=genere;
    }
}
