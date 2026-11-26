package it.rotech.libreria.exception;

public class LoginNotFoundException extends RuntimeException {
    public LoginNotFoundException (String message){
        super(message);
    }
    
    public LoginNotFoundException(){
        super("Utente non trovato");
    }

}
