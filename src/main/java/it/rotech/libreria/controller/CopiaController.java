package it.rotech.libreria.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.rotech.libreria.dto.CopiaDTO;
import it.rotech.libreria.dto.Request.CopiaRequest;
import it.rotech.libreria.service.CopiaService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController 
@RequestMapping ("/copie")
public class CopiaController {
    private CopiaService copiaService;

    public CopiaController (CopiaService copiaService) {
        this.copiaService=copiaService;
    }

    @GetMapping
    public ResponseEntity<List<CopiaDTO>> getAllCopie(){
        return ResponseEntity.ok(copiaService.findAllCopie());

    }    

    @GetMapping("/{id}")
    public ResponseEntity<CopiaDTO> getCopiaById(@PathVariable  Integer id) {
        return ResponseEntity.ok(copiaService.findById(id));
    }

    @PostMapping 
    public ResponseEntity<CopiaDTO> addCopia(@RequestBody CopiaRequest copiaRequest){
        return ResponseEntity.ok(copiaService.addCopia(copiaRequest));
    }

    @PutMapping ("/{id}")
    public ResponseEntity<CopiaDTO> updateCopia(@PathVariable Integer id, @RequestBody CopiaRequest copiaRequest) {
        return ResponseEntity.ok(copiaService.updateCopia(copiaRequest, id));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCopia(@PathVariable Integer id){
        copiaService.deleteCopia(id);
        return ResponseEntity.ok("Copia eliminata");
    }
    

}
