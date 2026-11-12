package it.rotech.libreria.service;

import it.rotech.libreria.utily.Mapper;
import org.springframework.stereotype.Service;

import it.rotech.libreria.dto.GenereDTO;
import it.rotech.libreria.dto.Request.GenereRequest;
import it.rotech.libreria.model.Genere;
import it.rotech.libreria.repository.GenereRepository;

@Service 
public class GenereService {
    private final Mapper mapper;
    private GenereRepository genereRepository;
     public GenereService (GenereRepository genereRepository, Mapper mapper) {
        this.genereRepository=genereRepository;
        this.mapper = mapper;
     }
    //Aggiungi genere
    public GenereDTO addGenere (GenereRequest genereRequest){
        String nome=genereRequest.getNome();
        Genere genereSalvato = new Genere(nome);
        return mapper.convertGenereToGenereDTO(genereRepository.save(genereSalvato));
    }

    public void deleteGenere (Integer id){
        genereRepository.deleteById(id);
    }
}
