package it.rotech.libreria.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import it.rotech.libreria.dto.LibroDTO;
import it.rotech.libreria.dto.Request.LibroRequest;
import it.rotech.libreria.model.Autore;
import it.rotech.libreria.model.Genere;
import it.rotech.libreria.model.Libro;
import it.rotech.libreria.repository.AutoreRepository;
import it.rotech.libreria.repository.GenereRepository;
import it.rotech.libreria.repository.LibroRepository;
import it.rotech.libreria.utily.Mapper;

@Service
public class LibroService {
    private final LibroRepository libroRepository;
    private final GenereRepository genereRepository;
    private final AutoreRepository autoreRepository;
    private final Mapper mapper;

    public LibroService(LibroRepository libroRepository, Mapper mapper, GenereRepository genereRepository,
            AutoreRepository autoreRepository) {
        this.libroRepository = libroRepository;
        this.mapper = mapper;
        this.genereRepository = genereRepository;
        this.autoreRepository = autoreRepository;
    }

    public List<LibroDTO> findAll() {

        List<Libro> risultato = libroRepository.findAll();
        List<LibroDTO> risultatoDTO = new ArrayList<>();
        for (Libro libro : risultato) {

            risultatoDTO.add(mapper.convertLibroToLibroDTO(libro));
        }
        return risultatoDTO;
    }

    // else throw per dare una seconda risposta per quando non ci sono dei libri con
    // quel id
    public LibroDTO findById(Integer id) {
        Libro libro = libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro non trovato con ID: " + id));
        return mapper.convertLibroToLibroDTO(libro);
    }

    public List<LibroDTO> findAllByTitolo(String titolo) {
        List<Libro> risultato = libroRepository.findAllByTitoloContainingIgnoreCase(titolo);
        List<LibroDTO> risultatoDTO = new ArrayList<>();

        for (Libro libro : risultato) {
            risultatoDTO.add(mapper.convertLibroToLibroDTO(libro));
        }

        return risultatoDTO;
    }

    public LibroDTO addLibro(LibroRequest libroRequest) {
        // devo inizializzare i vari punti che mi servono per aggiungere un libro
        String titolo = libroRequest.getTitolo();
        LocalDate anno= libroRequest.getAnno();
        String nomeG= libroRequest.getNomeGenere();
        String nomeA= libroRequest.getNomeAutore();
        String cognomeA=libroRequest.getCognomeAutore();

        Genere genere = genereRepository.findByNomeContainingIgnoreCase(nomeG);

        List<Autore> autoriDB = autoreRepository.findAllByNomeAndCognome(nomeA, cognomeA);
        // L'Optional di una lista non può funzionare perché il database
        // risponde comunque con una lista ma vuota. Devo gestire l'eccezione
        // manualmente.

        if (autoriDB.isEmpty())
            throw new RuntimeException("Autore non trovato, creare prima l'Autore!");
        Set<Autore> autori = new HashSet<>(autoriDB);
        
        Libro libroSalvato = new Libro(titolo, anno, genere, autori);
        return mapper.convertLibroToLibroDTO(libroRepository.save(libroSalvato));
    }

    public void deleteLibro(Integer id) {
        libroRepository.deleteById(id);
    }

    public LibroDTO modificaLibro(LibroRequest libroRequest, Integer idLibro) {
        // Vedo se il libro esiste
        String titolo = libroRequest.getTitolo();
        LocalDate anno= libroRequest.getAnno();
        String nomeG= libroRequest.getNomeGenere();
        String nomeA= libroRequest.getNomeAutore();
        String cognomeA=libroRequest.getCognomeAutore();
        Libro libro =libroRepository.findById(idLibro).orElseThrow(()->new RuntimeException("Libro con id "+idLibro + " non trovato."));
        Genere genere = genereRepository.findByNomeContainingIgnoreCase(nomeG);
        List<Autore> autoriDB = autoreRepository.findAllByNomeAndCognome(nomeA, cognomeA);
        // L'Optional di una lista non può funzionare perché il database
        // risponde comunque con una lista ma vuota. Devo gestire l'eccezione
        // manualmente.

        if (autoriDB.isEmpty())
            throw new RuntimeException("Autore non trovato, creare prima l'Autore!");
        Set<Autore> autori = new HashSet<>(autoriDB);
        libro.setTitolo(titolo);
        libro.setAnno(anno);
        libro.setGenere(genere);
        libro.setAutori(autori);
        return mapper.convertLibroToLibroDTO(libroRepository.save(libro));
    }

}
