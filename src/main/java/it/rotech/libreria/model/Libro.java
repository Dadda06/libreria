package it.rotech.libreria.model;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table (name ="Libri")
    
public class Libro {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name="idLibro")
    private Integer id;
    @Column (name="titolo")
    private String titolo;
    @Column (name = "anno")
    private LocalDate anno;
    @ManyToOne
    @JoinColumn (name = "fk_genere")
    private Genere genere;

    @ManyToMany 
    @JoinTable (
        name = "Libri_Autori",
        joinColumns = @JoinColumn (name = "fk_libro"),
        inverseJoinColumns = @JoinColumn (name= "fk_autore")
    )
    private Set<Autore> autori;


    public Libro (){}

    public Libro (String titolo, LocalDate anno, Genere genere, Set<Autore> autori) {
        this.titolo=titolo;
        this.anno=anno;
        this.genere=genere;
        this.autori=autori;
    }
    
    public Integer getId () {
        return id;
    }

    public void setId(Integer id){
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

    public Genere getGenere () {
        return genere;
    }

    public void setGenere (Genere genere) {
        this.genere=genere;
    }

    public Set<Autore> getAutori() {
        return autori;
    }

    public void setAutori(Set<Autore> autori) {
        this.autori = autori;
    }

}
