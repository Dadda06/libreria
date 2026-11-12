package it.rotech.libreria.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.rotech.libreria.dto.CasaEditriceDTO;
import it.rotech.libreria.dto.Request.CasaEditriceRequest;
import it.rotech.libreria.service.CasaEditriceService;

@RestController 
@RequestMapping ("/case")
public class CasaEditriceController {
    private CasaEditriceService casaEditriceService;

    public CasaEditriceController (CasaEditriceService casaEditriceService) {
        this.casaEditriceService=casaEditriceService;
    }
    
    @PostMapping
    public CasaEditriceDTO addCasa(@RequestBody CasaEditriceRequest casaEditriceRequest) {
        return casaEditriceService.addCasa(casaEditriceRequest);
    }

    @DeleteMapping("/id:{id}")
    public void deleteCasa(@PathVariable Integer id){
        casaEditriceService.deleteCasa(id);
    }
}
