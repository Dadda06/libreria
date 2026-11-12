package it.rotech.libreria.dto.Request;

public class GenereRequest {
    private String nome;

    public GenereRequest () {}
    
    public GenereRequest (String nome) {
        this.nome=nome;
    }

    public String getNome (){
        return nome;
    }

    public void setNome (String nome) {
        this.nome=nome;
    }

}
