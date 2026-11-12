package it.rotech.libreria.controller;

import java.util.List;

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
    public List<AutoreDTO> getAllAutori() {
        return autoreService.findAll();
    }

    @PostMapping 
    public AutoreDTO addAutore(@RequestBody AutoreRequest autoreRequest) {
        return autoreService.addAutore(autoreRequest);
    }

    @GetMapping("/id:{id}")
    public AutoreDTO getAutoreById(@PathVariable Integer id){
        return autoreService.findById(id);
    }

    @PutMapping("/id:{id}")
    public AutoreDTO modificaAutore(@PathVariable Integer id, @RequestBody AutoreRequest autoreRequest){
        return autoreService.modificaAutore(autoreRequest, id);
    }

    @DeleteMapping("/id:{id}")
    public void deleteAutore(@PathVariable Integer id){
        autoreService.deleteAutore(id);
    }

}
