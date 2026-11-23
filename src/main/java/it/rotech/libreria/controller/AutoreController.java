package it.rotech.libreria.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.rotech.libreria.dto.AutoreDTO;
import it.rotech.libreria.dto.Request.AutoreRequest;
import it.rotech.libreria.service.AutoreService;

@RestController 
@RequestMapping ("/autori")
public class AutoreController {
    private AutoreService autoreService;
    public AutoreController (AutoreService autoreService) {
        this.autoreService=autoreService;
    }

    @GetMapping 
    public ResponseEntity<List<AutoreDTO>> getAllAutori() {
        return ResponseEntity.ok(autoreService.findAll());
    }

    @PostMapping 
    public ResponseEntity<AutoreDTO> addAutore(@RequestBody AutoreRequest autoreRequest) {
        return ResponseEntity.ok(autoreService.addAutore(autoreRequest));
    }

    @GetMapping("/id:{id}")
    public ResponseEntity<AutoreDTO> getAutoreById(@PathVariable Integer id){
        return ResponseEntity.ok(autoreService.findById(id));
    }

    @PutMapping("/id:{id}")
    public ResponseEntity<AutoreDTO> modificaAutore(@PathVariable Integer id, @RequestBody AutoreRequest autoreRequest){
        return ResponseEntity.ok(autoreService.modificaAutore(autoreRequest, id));
    }

    @DeleteMapping("/id:{id}")
    public ResponseEntity<String> deleteAutore(@PathVariable Integer id){
        autoreService.deleteAutore(id);
        return ResponseEntity.ok("Autore eliminato");
    }

    @GetMapping("/find/{nome}/{cognome}")
    public ResponseEntity<List<AutoreDTO>> findAutoreNeC(@PathVariable  String nome,@PathVariable  String cognome) {
        return ResponseEntity.ok(autoreService.findByNomeECognome(nome, cognome));
    }
}
