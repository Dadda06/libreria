package it.rotech.libreria.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.rotech.libreria.dto.CopiaDTO;
import it.rotech.libreria.service.CopiaService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



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

    @GetMapping("/id:{id}")
    public CopiaDTO getCopiaById(@PathVariable  Integer id) {
        return copiaService.findById(id);
    }

    
    

}
