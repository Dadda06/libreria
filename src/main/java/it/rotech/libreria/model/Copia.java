package it.rotech.libreria.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table (name = "Copie")

public class Copia {
@Id 
@Column (name = "idCopia")
@GeneratedValue (strategy = GenerationType.IDENTITY)
private Integer id;
@Column (name = "numero_copie")
private Integer numeroCopie;
@ManyToOne
@JoinColumn (name = "fk_libro")
private Libro libro;
@ManyToOne
@JoinColumn (name = "fk_casa")
private CasaEditrice casaEditrice;

public Copia () {}

public Copia (Integer numeroCopie, Libro libro, CasaEditrice casaEditrice) {
    this.numeroCopie=numeroCopie;
    this.libro=libro;
    this.casaEditrice=casaEditrice;
}

public Integer getId() {
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
