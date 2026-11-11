package it.rotech.libreria.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import it.rotech.libreria.dto.LibroDTO;
import it.rotech.libreria.dto.Request.LibroRequest;
import it.rotech.libreria.service.LibroService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



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

    @GetMapping("/id:{id}")
    public LibroDTO getLibroById(@PathVariable Integer id) {
        return libroService.findById(id);
    }

    @GetMapping("/titolo:{titolo}")
    public List<LibroDTO> getLibroByTitolo(@PathVariable String titolo) {
        return libroService.findAllByTitolo(titolo);
    }

    @PostMapping
    public LibroDTO addLibro(@RequestBody LibroRequest libroRequest) {
        return libroService.addLibro(libroRequest);
    }
    @PutMapping("/id:{id}")
    public LibroDTO modificaLibro(@RequestBody LibroRequest libroRequest,@PathVariable  Integer id){
        return libroService.modificaLibro(libroRequest, id);
    } 
    @DeleteMapping ("/id:{id}")
    public void deleteLibro(@PathVariable Integer id) {
        libroService.deleteLibro(id);
    }
    
}
