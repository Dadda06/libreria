package it.rotech.libreria.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.rotech.libreria.dto.GenereDTO;
import it.rotech.libreria.dto.Request.GenereRequest;
import it.rotech.libreria.service.GenereService;

import java.util.List;

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
    public GenereDTO addGenere(@RequestBody GenereRequest genereRequest) {
        return genereService.addGenere(genereRequest);
    }
    
    @DeleteMapping("/id:{id}")
    public void deleteGenere(@PathVariable Integer id){
        genereService.deleteGenere(id);
    }
    
    @GetMapping
    public List<GenereDTO> getAll(){
        return genereService.findAll();
    }

    @GetMapping("/nome:{nome}")
    public List<GenereDTO> getByNome(@PathVariable String nome) {
        return genereService.findByNome(nome);
    }
}
