package it.rotech.libreria.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice 
public class LibreriaExceptionHandler {
    @ExceptionHandler (LibroNotFoundException.class)
    public ResponseEntity<String> gestisciLibroNotFound(LibroNotFoundException ex){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }
    
    @ExceptionHandler (AutoreNotFoundException.class)
    public ResponseEntity<String> gestisciAutoreNotFound(AutoreNotFoundException ex){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }

    @ExceptionHandler (CopiaNotFoundException.class)
    public ResponseEntity<String> gestisciCopiaNotFound(CopiaNotFoundException ex){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }

    @ExceptionHandler (CasaEditriceNotFoundException.class)
    public ResponseEntity<String> gestisciCasaEditriceNotFound(CasaEditriceNotFoundException ex){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }

    @ExceptionHandler (GenereNotFoundException.class)
    public ResponseEntity<String> gestisciGenereNotFound(GenereNotFoundException ex){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }




}
