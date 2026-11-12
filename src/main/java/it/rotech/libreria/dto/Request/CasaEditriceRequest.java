package it.rotech.libreria.dto.Request;

public class CasaEditriceRequest {
        
    private String nome;
    public CasaEditriceRequest (){}

    public CasaEditriceRequest (String nome) {
        this.nome=nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome (String nome) {
        this.nome=nome;
    }

}
