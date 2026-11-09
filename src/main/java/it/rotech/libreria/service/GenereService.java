package it.rotech.libreria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.rotech.libreria.repository.GenereRepository;

@Service 
public class GenereService {
    @Autowired 
    private GenereRepository genereRepository;

    //Aggiungi genere
    /*public Genere findByGenere(String genere){
        return genereRepository.findById(3).orElseThrow(() -> new RuntimeException("Il genere con id 3 non esiste"));
    }*/
}
