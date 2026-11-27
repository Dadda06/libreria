package it.rotech.libreria.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CasaEditriceDTO {

    private Integer id;
    
    @NotBlank(message = "Il nome della casa editrice è obbligatorio")
    @Size(min = 2, max = 100, message = "Il nome della casa editrice deve essere compreso tra 2 e 100 caratteri")
    private String nome;

    public CasaEditriceDTO () {}

public CasaEditriceDTO (String nome) {
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
