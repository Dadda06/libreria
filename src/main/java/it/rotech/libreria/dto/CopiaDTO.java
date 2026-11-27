package it.rotech.libreria.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class CopiaDTO {

    private Integer id;
    
    @NotNull(message = "Il numero di copie è obbligatorio")
    @Min(value = 1, message = "Il numero di copie deve essere almeno 1")
    private Integer numeroCopie;

    @NotNull(message = "Il libro associato è obbligatorio")
    @Valid // Valida anche i campi interni del LibroDTO
    private LibroDTO libro;

    @NotNull(message = "La casa editrice è obbligatoria")
    @Valid // Valida anche i campi interni del CasaEditriceDTO
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
