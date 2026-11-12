package it.rotech.libreria.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import it.rotech.libreria.dto.AutoreDTO;
import it.rotech.libreria.dto.Request.AutoreRequest;
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

    public List<AutoreDTO> findAll(){
        List<Autore> risultato = autoreRepository.findAll();
        List<AutoreDTO> risultatoDTO = new ArrayList<>();
        for (Autore autore : risultato){
            risultatoDTO.add(mapper.convertAutoreToAutoreDTO(autore));
        }
        return risultatoDTO;
    }

    public AutoreDTO addAutore(AutoreRequest autoreRequest) {
        String nome= autoreRequest.getNome();
        String cognome= autoreRequest.getCognome();
        LocalDate dataNascita=autoreRequest.getDataNascita();
        String nazionalita=autoreRequest.getNazionalita();
        Autore autoreSalvato = new Autore(nome, cognome, dataNascita, nazionalita);
        return mapper.convertAutoreToAutoreDTO(autoreRepository.save(autoreSalvato));

    }

    public AutoreDTO findById(Integer id) {
        Autore autore=autoreRepository.findById(id).orElseThrow(()-> new RuntimeException("Autore non esistente con questo id: " + id));
        return mapper.convertAutoreToAutoreDTO(autore);
    }

    public AutoreDTO modificaAutore(AutoreRequest autoreRequest, Integer id){
        String nome= autoreRequest.getNome();
        String cognome= autoreRequest.getCognome();
        LocalDate dataNascita=autoreRequest.getDataNascita();
        String nazionalita=autoreRequest.getNazionalita();
        Autore autore= autoreRepository.findById(id).orElseThrow(()->new RuntimeException("Autore con id: "+ id + " non trovato."));
        autore.setNome(nome);
        autore.setCognome(cognome);
        autore.setDataNascita(dataNascita);
        autore.setNazionalita(nazionalita);
        return mapper.convertAutoreToAutoreDTO(autoreRepository.save(autore));
    }

    public void deleteAutore(Integer id){
        autoreRepository.deleteById(id);
    }

    public AutoreDTO findAllByNomeECognome(String nome, String cognome){
        List<Autore> risultato = autoreRepository.findAllByNomeAndCognome(nome, cognome);
        List<AutoreDTO> risultatoDTO = new ArrayList<>();
    
        for (Autore autore : risultato) {
            risultatoDTO.add(mapper.convertAutoreToAutoreDTO(autore));
        } 
    
        return risultatoDTO; 
}

}
