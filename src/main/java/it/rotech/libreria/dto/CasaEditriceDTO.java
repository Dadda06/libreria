package it.rotech.libreria.dto;

public class CasaEditriceDTO {

    private Integer idCasa;
    private String nome;

    public CasaEditriceDTO () {}

public CasaEditriceDTO (Integer idCasa, String nome) {
    this.idCasa=idCasa;
    this.nome=nome;
}

public Integer getIdCasa () {
    return idCasa;
}

public void setIdCasa (Integer idCasa) {
    this.idCasa=idCasa;
}

public String getNome () {
    return nome;
}

public void setNome (String nome) {
    this.nome=nome;
}
}
