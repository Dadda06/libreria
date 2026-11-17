package it.rotech.libreria.exception;

public class LibroNotFoundException extends RuntimeException {
    public LibroNotFoundException (String message){
        super(message);
    }

}
