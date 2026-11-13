package it.rotech.libreria.service;

import it.rotech.libreria.utily.Mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.rotech.libreria.dto.GenereDTO;
import it.rotech.libreria.dto.Request.GenereRequest;
import it.rotech.libreria.model.Genere;
import it.rotech.libreria.model.Libro;
import it.rotech.libreria.repository.GenereRepository;
import it.rotech.libreria.repository.LibroRepository;

@Service 
public class GenereService {
    private Mapper mapper;
    private GenereRepository genereRepository;
    private LibroRepository libroRepository;
     public GenereService (GenereRepository genereRepository, Mapper mapper, LibroRepository libroRepository) {
        this.genereRepository=genereRepository;
        this.mapper = mapper;
        this.libroRepository=libroRepository;
     }
    //Aggiungi genere
    public GenereDTO addGenere (GenereRequest genereRequest){
        String nome=genereRequest.getNome();
        Genere genereSalvato = new Genere(nome);
        return mapper.convertGenereToGenereDTO(genereRepository.save(genereSalvato));
    }

    @Transactional 
    public void deleteGenere (Integer id){
    //Trovo il genere da eliminare
       List<Libro> libriAssociati = libroRepository.findByGenere_Id(id);

        // 2. Sgancia i libri impostando il genere a null (o salvando la modifica)
        for (Libro libro : libriAssociati) {
            libro.setGenere(null); 
            libroRepository.save(libro);
        }

        // 3. Ora puoi eliminare il genere in sicurezza
        genereRepository.deleteById(id);
    
    }

    public List<GenereDTO> findAll(){
        List<Genere> risultato= genereRepository.findAll();
        List<GenereDTO> risultatoDTO= new ArrayList<>();
        for (Genere genere: risultato){
            risultatoDTO.add(mapper.convertGenereToGenereDTO(genere));
        }
        return risultatoDTO;
    }

    public List<GenereDTO> findByNome(String nome){
        List<Genere> risultato=genereRepository.findAllByNome(nome);
        List<GenereDTO> risultatoDTO=new ArrayList<>();
        for (Genere genere: risultato){
            risultatoDTO.add(mapper.convertGenereToGenereDTO(genere));
        }
        return risultatoDTO;
    }
}
