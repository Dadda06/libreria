package it.rotech.libreria.dto;

public class GenereDTO {

    private Integer id;
    private String nome;
    
    public GenereDTO () {}

    public GenereDTO ( String nome) {
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
