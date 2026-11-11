package it.rotech.libreria.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import it.rotech.libreria.dto.CopiaDTO;
import it.rotech.libreria.model.CasaEditrice;
import it.rotech.libreria.model.Copia;
import it.rotech.libreria.model.Libro;
import it.rotech.libreria.repository.CasaEditriceRepository;
import it.rotech.libreria.repository.CopiaRepository;
import it.rotech.libreria.repository.LibroRepository;
import it.rotech.libreria.utily.Mapper;

@Service 
public class CopiaService {
    private final CopiaRepository copiaRepository;
    private final Mapper mapper;
    private final LibroRepository libroRepository;
    private final CasaEditriceRepository casaEditriceRepository;

    public CopiaService (CopiaRepository copiaRepository, Mapper mapper, LibroRepository libroRepository, CasaEditriceRepository casaEditriceRepository) {
        this.copiaRepository=copiaRepository;
        this.mapper=mapper;
        this.libroRepository=libroRepository;
        this.casaEditriceRepository=casaEditriceRepository;
    }

    public List<CopiaDTO> findAllCopie(){
        List <Copia> risultato = copiaRepository.findAll();
        List <CopiaDTO> risultatoDTO = new ArrayList<>();
        for (Copia copia : risultato){
            risultatoDTO.add(mapper.convertCopiaToCopiaDTO(copia));
        }
        return risultatoDTO;
    }

    public CopiaDTO findById (Integer id){
        Copia copia = copiaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Copie non trovato con ID: " + id));
        return mapper.convertCopiaToCopiaDTO(copia);
    }

    // public CopiaDTO addCopia (Integer numCopie, String titoloLibro, String casa){
    //     Lis libro = libroRepository.findAllByTitoloContainingIgnoreCase(titoloLibro);
    //     List <CasaEditrice> casaDB = casaEditriceRepository.findAllByNome(casa);

    // }
}
