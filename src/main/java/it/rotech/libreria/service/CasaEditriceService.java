package it.rotech.libreria.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import it.rotech.libreria.dto.CasaEditriceDTO;
import it.rotech.libreria.dto.Request.CasaEditriceRequest;
import it.rotech.libreria.model.CasaEditrice;
import it.rotech.libreria.repository.CasaEditriceRepository;
import it.rotech.libreria.utily.Mapper;

@Service 
public class CasaEditriceService {
    private final CasaEditriceRepository casaEditriceRepository;
    private final Mapper mapper;

    public CasaEditriceService (CasaEditriceRepository casaEditriceRepository, Mapper mapper){
        this.casaEditriceRepository=casaEditriceRepository;
        this.mapper=mapper;
    }

    public CasaEditriceDTO addCasa(CasaEditriceRequest casaEditriceRequest) {
        String nome = casaEditriceRequest.getNome();
        CasaEditrice casaSalvata = new CasaEditrice(nome);
        return mapper.convertCasaEditriceToCasaEditriceDTO(casaEditriceRepository.save(casaSalvata));
    }

    public void deleteCasa(Integer id) {
        casaEditriceRepository.deleteById(id);
    }

    public List<CasaEditriceDTO> findAll(){
        List<CasaEditrice> risultato = casaEditriceRepository.findAll();
        List<CasaEditriceDTO> risultatoDTO = new ArrayList<>();
        for (CasaEditrice casaEditrice : risultato){
            risultatoDTO.add(mapper.convertCasaEditriceToCasaEditriceDTO(casaEditrice));
        }
        return risultatoDTO;
    }

    public List<CasaEditriceDTO> findByNome(String nome){
        List<CasaEditrice> risultato=casaEditriceRepository.findAllByNome(nome);
        List<CasaEditriceDTO> risultatoDTO=new ArrayList<>();
        for (CasaEditrice casaEditrice: risultato){
            risultatoDTO.add(mapper.convertCasaEditriceToCasaEditriceDTO(casaEditrice));
        }
        return risultatoDTO;
    }
}
