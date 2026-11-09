package it.rotech.libreria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.rotech.libreria.dto.LibroDTO;
import it.rotech.libreria.model.Libro;
import it.rotech.libreria.service.LibroService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController 
@RequestMapping ("/libri")
public class LibroController {
    @Autowired 
    private LibroService libroService;

    @GetMapping
    public List<LibroDTO> getAllLibro() {
        return libroService.findAll();
    }
    
}
