package it.rotech.libreria.dto;

import java.time.LocalDate;

import it.rotech.libreria.model.Genere;

public class LibroDTO {

    private Integer idLibro;
    private String titolo;
    private LocalDate anno;
    private Genere genere;

    public LibroDTO () {}
    
    public LibroDTO (Integer idLibro, String titolo, LocalDate anno, Genere genere) {
        this.idLibro=idLibro;
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
