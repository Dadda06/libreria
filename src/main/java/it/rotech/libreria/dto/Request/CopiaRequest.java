package it.rotech.libreria.dto.Request;

public class CopiaRequest {

    private Integer numCopie;
    private Integer idLibro;
    private String casa;

    public CopiaRequest(Integer numCopie, Integer idLibro, String casa) {
        this.numCopie = numCopie;
        this.idLibro = idLibro;
        this.casa = casa;
    }

    public CopiaRequest () {}

    public Integer getNumCopie() {
        return numCopie;
    }

    public void setNumCopie(Integer numCopie) {
        this.numCopie = numCopie;
    }

    public Integer getidLibro() {
        return idLibro;
    }

    public void setidLibro(Integer idLibro) {
        this.idLibro = idLibro;
    }

    public String getCasa() {
        return casa;
    }

    public void setCasa(String casa) {
        this.casa = casa;
    }
    

}
