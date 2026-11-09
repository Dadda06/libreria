package it.rotech.libreria.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.rotech.libreria.dto.LibroDTO;
import it.rotech.libreria.service.LibroService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController 
@RequestMapping ("/libri")
public class LibroController {

    private LibroService libroService;
    public LibroController (LibroService libroService) {
        this.libroService=libroService;
    }

    @GetMapping
    public List<LibroDTO> getAllLibri() {
        return libroService.findAll();
    }

    @GetMapping("/{id}")
    public LibroDTO getLibroById(@PathVariable Integer id) {
        return libroService.findById(id);
    }
    
}
