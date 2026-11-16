package it.rotech.libreria.dto.Request;

import java.time.LocalDate;
import java.util.List;


public class LibroRequest {
    private String titolo;
    private LocalDate anno;
    private String nomeGenere;
    private List<AutoreRequest> autori;

    public LibroRequest() {}

    public LibroRequest (String titolo, LocalDate anno, String nomeGenere, List<AutoreRequest> autori) {
        this.titolo=titolo;
        this.anno=anno;
        this.nomeGenere=nomeGenere;
        this.autori=autori;
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

    public List<AutoreRequest> getAutori() {
        return autori;
    }

    public void setAutori (List<AutoreRequest> autori) {
        this.autori=autori;
    }
    
}
