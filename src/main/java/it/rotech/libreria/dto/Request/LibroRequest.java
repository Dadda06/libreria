package it.rotech.libreria.dto.Request;

import java.time.LocalDate;


public class LibroRequest {
    private String titolo;
    private LocalDate anno;
    private String nomeGenere;
    private String nomeAutore;
    private String cognomeAutore;

    public LibroRequest() {}

    public LibroRequest (String titolo, LocalDate anno, String nomeGenere, String nomeAutore, String cognomeAutore) {
        this.titolo=titolo;
        this.anno=anno;
        this.nomeGenere=nomeGenere;
        this.nomeAutore=nomeAutore;
        this.cognomeAutore=cognomeAutore;
    }

    public String getTitolo () {
        return titolo;
    }

    public void setTitolo (String titolo) {
        this.titolo=titolo;
    }

    public LocalDate getAnno () {
        return anno;
    }

    public void setAnno (LocalDate anno) {
        this.anno=anno;
    }

    public String getNomeGenere () {
        return nomeGenere;
    }

    public void setNomeGenere (String nomeGenere) {
        this.nomeGenere=nomeGenere;
    }

    public String getNomeAutore () {
        return nomeAutore;
    }

    public void setNomeAutore (String nomeAutore) {
        this.nomeAutore=nomeAutore;
    }

    public String getCognomeAutore () {
        return cognomeAutore;
    }

    public void setCognomeAutore (String cognomeAutore) {
        this.cognomeAutore=cognomeAutore;
    }
    
}
