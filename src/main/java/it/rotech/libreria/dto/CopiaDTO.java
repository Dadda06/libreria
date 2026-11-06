package it.rotech.libreria.dto;

import it.rotech.libreria.model.CasaEditrice;
import it.rotech.libreria.model.Libro;

public class CopiaDTO {

    private Integer idCopia;
    private Integer numeroCopie;
    private Libro libro;
    private CasaEditrice casaEditrice;
    
    public CopiaDTO () {}

public CopiaDTO (Integer idCopia, Integer numeroCopie, Libro libro, CasaEditrice casaEditrice) {
    this.idCopia=idCopia;
    this.numeroCopie=numeroCopie;
    this.libro=libro;
    this.casaEditrice=casaEditrice;
}

public Integer getIdCopia () {
    return idCopia;
}

public void setIdCopia (Integer idCopia) {
    this.idCopia=idCopia;
} 

public Integer getNumeroCopie () {
    return numeroCopie;
}

public void setNumeroCopie (Integer numeroCopie) {
    this.numeroCopie=numeroCopie;
}

public Libro getLibro () {
    return libro;
}

public void setLibro (Libro libro) {
    this.libro=libro;
}

public CasaEditrice getCasaEditrice () {
    return casaEditrice;
}

public void setCasaEditrice (CasaEditrice casaEditrice) {
    this.casaEditrice=casaEditrice;
}

}
