package it.rotech.libreria.dto;

import java.time.LocalDate;


public class LibroDTO {

    private Integer id;
    private String titolo;
    private LocalDate anno;
    private GenereDTO genere;

    public LibroDTO () {}
    
    public LibroDTO (String titolo, LocalDate anno, GenereDTO genere) {
        this.titolo=titolo;
        this.anno=anno;
        this.genere=genere;
    }

    public Integer getId () {
        return id;
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

    public GenereDTO getGenere () {
        return genere;
    }

    public void setGenere (GenereDTO genere) {
        this.genere=genere;
    }


}
