package it.rotech.libreria.controller;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.rotech.libreria.dto.AutoreDTO;
import it.rotech.libreria.service.AutoreService;

@RestController 
@RequestMapping ("/autori")
public class AutoreController {
    private AutoreService autoreService;
    public AutoreController (AutoreService autoreService) {
        this.autoreService=autoreService;
    }

    @PostMapping 
    public AutoreDTO addAutore(@RequestParam String nome, @RequestParam String cognome, @RequestParam LocalDate dataNascita, @RequestParam String nazionalita) {
        return autoreService.addAutore(nome, cognome, dataNascita, nazionalita);
    }

}
