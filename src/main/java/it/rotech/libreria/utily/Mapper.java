package it.rotech.libreria.utily;

import org.springframework.stereotype.Component;

import it.rotech.libreria.dto.AutoreDTO;
import it.rotech.libreria.dto.CasaEditriceDTO;
import it.rotech.libreria.dto.CopiaDTO;
import it.rotech.libreria.dto.GenereDTO;
import it.rotech.libreria.dto.LibroDTO;
import it.rotech.libreria.model.Autore;
import it.rotech.libreria.model.CasaEditrice;
import it.rotech.libreria.model.Copia;
import it.rotech.libreria.model.Genere;
import it.rotech.libreria.model.Libro;
@Component 
public class Mapper {
    public Mapper () {}

    public LibroDTO convertLibroToLibroDTO (Libro libro) {
        // 1. Creo l'oggetto di ritorno vuoto
        LibroDTO libroDTO=new LibroDTO();
        //2. Inizializzo le  variabili tramite i setter della classe Libro
        libroDTO.setId(libro.getId());
        libroDTO.setTitolo(libro.getTitolo());
        libroDTO.setAnno(libro.getAnno());
        libroDTO.setGenere(convertGenereToGenereDTO(libro.getGenere()));
        // 3. Ritorno l'oggetto inizializzato
        return libroDTO;
    }
    
    public Libro convertLibroDTOToLibro (LibroDTO libroDTO) {
        Libro libro=new Libro();
        libro.setTitolo(libroDTO.getTitolo());
        libro.setAnno(libroDTO.getAnno());
        libro.setGenere(convertGenereDTOToGenere(libroDTO.getGenere()));
        return libro;
    }

    public GenereDTO convertGenereToGenereDTO (Genere genere) {
        GenereDTO genereDTO = new GenereDTO();
        genereDTO.setId(genere.getId());
        genereDTO.setNome(genere.getNome());
        return genereDTO;
    }

    public Genere convertGenereDTOToGenere (GenereDTO genereDTO) {
        Genere genere= new Genere();
        genere.setNome(genereDTO.getNome());
        return genere;
    }

    public CopiaDTO convertCopiaToCopiaDTO (Copia copia) {
        CopiaDTO copiaDTO=new CopiaDTO();
        copiaDTO.setId(copia.getId());
        copiaDTO.setNumeroCopie(copia.getNumeroCopie());
        copiaDTO.setLibroDTO(convertLibroToLibroDTO(copia.getLibro()));
        copiaDTO.setCasaEditriceDTO(convertCasaEditriceToCasaEditriceDTO(copia.getCasaEditrice()));
        return copiaDTO;
    }

    public Copia convertCopiaDTOToCopia (CopiaDTO copiaDTO) {
        Copia copia = new Copia();
        copia.setNumeroCopie(copiaDTO.getNumeroCopie());
        copia.setCasaEditrice(convertCasaEditriceDTOToCasaEditrice(copiaDTO.getCasaEditrice()));
        copia.setLibro(convertLibroDTOToLibro(copiaDTO.getLibro()));
        return copia;
    }

    public CasaEditriceDTO convertCasaEditriceToCasaEditriceDTO (CasaEditrice casaEditrice){
        CasaEditriceDTO casaEditriceDTO= new CasaEditriceDTO();
        casaEditriceDTO.setId(casaEditrice.getId());
        casaEditriceDTO.setNome(casaEditrice.getNome());
        return casaEditriceDTO;
    }

    public CasaEditrice convertCasaEditriceDTOToCasaEditrice (CasaEditriceDTO casaEditriceDTO) {
        CasaEditrice casaEditrice= new CasaEditrice();
        casaEditrice.setNome(casaEditriceDTO.getNome());
        return casaEditrice;
    }

    public AutoreDTO convertAutoreToAutoreDTO (Autore autore) {
        AutoreDTO autoreDTO = new AutoreDTO();
        autoreDTO.setId(autore.getId());
        autoreDTO.setNome(autore.getNome());
        autoreDTO.setCognome(autore.getCognome());
        autoreDTO.setDataNascita(autore.getDataNascita());
        autoreDTO.setNazionalita(autore.getNazionalita());
        return autoreDTO;
    }

    public Autore convertAutoreDTOToAutore (AutoreDTO autoreDTO) {
        Autore autore= new Autore();
        autore.setNome(autoreDTO.getNome());
        autore.setCognome(autoreDTO.getCognome());
        autore.setDataNascita(autoreDTO.getDataNascita());
        autore.setNazionalita(autoreDTO.getNazionalita());
        return autore;
    }
}
