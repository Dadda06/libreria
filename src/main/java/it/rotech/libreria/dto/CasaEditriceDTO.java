package it.rotech.libreria.dto;

public class CasaEditriceDTO {

    private Integer id;
    private String nome;

    public CasaEditriceDTO () {}

public CasaEditriceDTO (String nome) {
    this.nome=nome;
}

public Integer getId () {
    return id;
}

public String getNome () {
    return nome;
}

public void setNome (String nome) {
    this.nome=nome;
}
}
