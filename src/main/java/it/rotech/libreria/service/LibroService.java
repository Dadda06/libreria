package it.rotech.libreria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.rotech.libreria.model.Libro;
import it.rotech.libreria.repository.LibroRepository;

@Service 
public class LibroService {
    @Autowired 
    private LibroRepository libroRepository;

    public List<Libro> findAll() {
        return libroRepository.findAll();
    }

}
