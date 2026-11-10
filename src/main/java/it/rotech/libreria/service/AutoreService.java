package it.rotech.libreria.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import it.rotech.libreria.dto.AutoreDTO;
import it.rotech.libreria.model.Autore;
import it.rotech.libreria.repository.AutoreRepository;
import it.rotech.libreria.utily.Mapper;

@Service 
public class AutoreService {
    private final AutoreRepository autoreRepository;
    private final Mapper mapper;

    public AutoreService (AutoreRepository autoreRepository, Mapper mapper) {
        this.autoreRepository=autoreRepository;
        this.mapper=mapper;
    }

    public AutoreDTO addAutore(String nome, String cognome, LocalDate dataNascita, String nazionalita) {
        Autore autoreSalvato = new Autore(nome, cognome, dataNascita, nazionalita);
        return mapper.convertAutoreToAutoreDTO(autoreRepository.save(autoreSalvato));

    }
}
