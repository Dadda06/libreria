package it.rotech.libreria.dto;


public class CopiaDTO {

    private Integer id;
    private Integer numeroCopie;
    private LibroDTO libro;
    private CasaEditriceDTO casaEditrice;
    
    public CopiaDTO () {}

public CopiaDTO (Integer numeroCopie, LibroDTO libro, CasaEditriceDTO casaEditrice) {
    this.numeroCopie=numeroCopie;
    this.libro=libro;
    this.casaEditrice=casaEditrice;
}

public Integer getId () {
    return id;
}

public void setId (Integer id) {
    this.id=id;
}

public Integer getNumeroCopie () {
    return numeroCopie;
}

public void setNumeroCopie (Integer numeroCopie) {
    this.numeroCopie=numeroCopie;
}

public LibroDTO getLibro () {
    return libro;
}

public void setLibroDTO (LibroDTO libro) {
    this.libro=libro;
}

public CasaEditriceDTO getCasaEditrice () {
    return casaEditrice;
}

public void setCasaEditriceDTO (CasaEditriceDTO casaEditrice) {
    this.casaEditrice=casaEditrice;
}

}
