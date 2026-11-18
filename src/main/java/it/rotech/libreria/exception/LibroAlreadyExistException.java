package it.rotech.libreria.exception;

public class LibroAlreadyExistException extends RuntimeException{
    public LibroAlreadyExistException (String message){
        super(message);
    }

}
