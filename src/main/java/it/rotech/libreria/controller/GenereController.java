package it.rotech.libreria.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.rotech.libreria.dto.GenereDTO;
import it.rotech.libreria.dto.Request.GenereRequest;
import it.rotech.libreria.service.GenereService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController 
@RequestMapping ("/generi")
public class GenereController {
    private GenereService genereService;
    public GenereController (GenereService genereService){
        this.genereService=genereService;
    }

    @PostMapping
    public ResponseEntity<GenereDTO> addGenere(@RequestBody GenereRequest genereRequest) {
        return ResponseEntity.ok(genereService.addGenere(genereRequest));
    }
    
    @DeleteMapping("/id:{id}")
    public ResponseEntity<String> deleteGenere(@PathVariable Integer id){
        genereService.deleteGenere(id);
        return ResponseEntity.ok("Genere eliminato");
    }
    
    @GetMapping
    public ResponseEntity<List<GenereDTO>> getAll(){
        return ResponseEntity.ok(genereService.findAll());
    }

    @GetMapping("/nome:{nome}")
    public ResponseEntity<List<GenereDTO>> getByNome(@PathVariable String nome) {
        return ResponseEntity.ok(genereService.findByNome(nome));
    }
}
