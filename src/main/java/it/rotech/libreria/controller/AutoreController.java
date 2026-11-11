package it.rotech.libreria.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

}
