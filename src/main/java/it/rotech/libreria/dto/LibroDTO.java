package it.rotech.libreria.dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


public class LibroDTO {

    private Integer id;
    private String titolo;
    private LocalDate anno;
    private GenereDTO genere;
    private Set<AutoreDTO> autori = new HashSet<>();

    public LibroDTO () {}
    
    public LibroDTO (String titolo, LocalDate anno, GenereDTO genere, Set<AutoreDTO> autori) {
        this.titolo=titolo;
        this.anno=anno;
        this.genere=genere;
        this.autori=autori;
    }

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id=id;
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

    public Set<AutoreDTO> getAutori () {
        return autori;
    }

    public void setAutori (Set<AutoreDTO> autori) {
        this.autori=autori;
    }
}
