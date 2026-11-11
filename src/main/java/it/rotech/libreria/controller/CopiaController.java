package it.rotech.libreria.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.rotech.libreria.dto.CopiaDTO;
import it.rotech.libreria.dto.Request.CopiaRequest;
import it.rotech.libreria.service.CopiaService;

import java.util.List;

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
    public List <CopiaDTO> getAllCopie(){
        return copiaService.findAllCopie();

    }    

    @GetMapping("/{id}")
    public CopiaDTO getCopiaById(@PathVariable  Integer id) {
        return copiaService.findById(id);
    }

    @PostMapping 
    public CopiaDTO addCopia(@RequestBody CopiaRequest copiaRequest){
        return copiaService.addCopia(copiaRequest);
    }

    @PutMapping ("/{id}")
    public CopiaDTO updateCopia(@PathVariable Integer id, @RequestBody CopiaRequest copiaRequest) {
        return copiaService.updateCopia(copiaRequest, id);
    }
    
    @DeleteMapping("/{id}")
    public void deleteCopia(@PathVariable Integer id){
        copiaService.deleteCopia(id);
    }
    

}
