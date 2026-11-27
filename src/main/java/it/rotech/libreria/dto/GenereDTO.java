package it.rotech.libreria.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class GenereDTO {

    private Integer id;
    
    @NotBlank(message = "Il nome del genere è obbligatorio")
    @Size(min = 2, max = 50, message = "Il nome del genere deve essere compreso tra 2 e 50 caratteri")
    private String nome;
    
    public GenereDTO () {}

    public GenereDTO ( String nome) {
        this.nome=nome;
    }

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id=id;
    }
    public String getNome () {
        return nome;
    }

    public void setNome (String nome) {
        this.nome=nome;
    }
}
