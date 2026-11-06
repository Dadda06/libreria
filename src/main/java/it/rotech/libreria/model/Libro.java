package it.rotech.libreria.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    @OneToMany(mappedBy = "libro")
    private Set<Copia> Copie=new HashSet<>(); 
    @ManyToMany 
    @JoinTable (
        name = "Libri_Autori",
        joinColumns = @JoinColumn (name = "fk_libro"),
        inverseJoinColumns = @JoinColumn (name= "fk_autore")
    )
    private Set<Autore> autore;


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

    public Set<Copia> getCopie () {
        return Copie;
    }

    public void setCopie (Set<Copia> Copie) {
        this.Copie=Copie;
    }
}
