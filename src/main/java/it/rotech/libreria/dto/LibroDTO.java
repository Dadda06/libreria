package it.rotech.libreria.dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;


public class LibroDTO {

    private Integer id;
    
    @NotBlank(message = "Il titolo è obbligatorio e non può essere vuoto")
    private String titolo;

    @NotNull(message = "La data di pubblicazione è obbligatoria")
    @PastOrPresent(message = "La data di pubblicazione non può essere nel futuro")
    private LocalDate anno;

    @NotNull(message = "Il genere è obbligatorio")
    @Valid // Dice a Spring di validare anche i campi interni di GenereDTO
    private GenereDTO genere;

    @NotEmpty(message = "Il libro deve avere almeno un autore")
    @Valid // Dice a Spring di validare ogni AutoreDTO presente nel Set
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
