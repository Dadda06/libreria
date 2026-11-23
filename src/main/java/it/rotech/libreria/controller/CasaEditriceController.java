package it.rotech.libreria.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ResponseEntity<CasaEditriceDTO> addCasa(@RequestBody CasaEditriceRequest casaEditriceRequest) {
        return ResponseEntity.ok(casaEditriceService.addCasa(casaEditriceRequest));
    }

    @DeleteMapping("/id:{id}")
    public ResponseEntity<String> deleteCasa(@PathVariable Integer id){
        casaEditriceService.deleteCasa(id);
        return ResponseEntity.ok("Casa Editrice eliminata");
    }

    @GetMapping
    public ResponseEntity<List<CasaEditriceDTO>> getAll(){
        return ResponseEntity.ok(casaEditriceService.findAll());
    }

    @GetMapping("/nome:{nome}")
    public ResponseEntity<List<CasaEditriceDTO>> getByNome(@PathVariable String nome) {
        return ResponseEntity.ok(casaEditriceService.findByNome(nome));
    }
    
}
