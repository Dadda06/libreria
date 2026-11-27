package it.rotech.libreria.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import it.rotech.libreria.dto.LibroDTO;
import it.rotech.libreria.dto.Request.LibroRequest;
import it.rotech.libreria.service.LibroService;
import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController 
@RequestMapping ("/libri")
public class LibroController {

    private LibroService libroService;
    public LibroController (LibroService libroService) {
        this.libroService=libroService;
    }

    @GetMapping
    public ResponseEntity<List<LibroDTO>> getAllLibri() {
        return ResponseEntity.ok(libroService.findAll());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<LibroDTO> getLibroById(@PathVariable Integer id) {
        return ResponseEntity.ok(libroService.findById(id));
    }

    @GetMapping("/{titolo}")
    public ResponseEntity<List<LibroDTO>> getLibroByTitolo(@PathVariable String titolo) {
        return ResponseEntity.ok(libroService.findAllByTitolo(titolo));
    }

    @PostMapping
    public ResponseEntity<LibroDTO> addLibro(@Valid @RequestBody LibroRequest libroRequest) {
        return ResponseEntity.ok(libroService.addLibro(libroRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibroDTO> modificaLibro(@Valid @RequestBody LibroRequest libroRequest,@PathVariable  Integer id){
        return ResponseEntity.ok(libroService.modificaLibro(libroRequest, id));
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<String> deleteLibro(@PathVariable Integer id) {
        libroService.deleteLibroAndCopie(id);
        return ResponseEntity.ok("Libro cancellato");
    }

    @GetMapping("/{nomeG}")
    public ResponseEntity<List<LibroDTO>> getLibroByGenere(@PathVariable String nomeG) {
        return ResponseEntity.ok(libroService.findByGenere(nomeG));
    }

    @GetMapping("/autore/{nomeA}/{cognomeA}")
    public ResponseEntity<List<LibroDTO>> getLibroByAutore(@PathVariable String nomeA, @PathVariable String cognomeA){
        //ResponseEntity.status(HttpStatus.OK).body(libroService.findByAutore(nomeA, cognomeA));
        return ResponseEntity.ok(libroService.findByAutore(nomeA, cognomeA));
        //si può scrivere il return in entrambe le maniere
    }
}
