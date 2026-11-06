package it.rotech.libreria.utily;

import org.springframework.stereotype.Component;

import it.rotech.libreria.dto.CopiaDTO;
import it.rotech.libreria.dto.GenereDTO;
import it.rotech.libreria.dto.LibroDTO;
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
        libroDTO.setIdLibro(libro.getIdLibro());
        libroDTO.setTitolo(libro.getTitolo());
        libroDTO.setAnno(libro.getAnno());
        libroDTO.setGenere(libro.getGenere());
        // 3. Ritorno l'oggetto inizializzato
        return libroDTO;
    }
    
    public Libro convertLibroDTOToLibro (LibroDTO libroDTO) {
        Libro libro=new Libro();
        libro.setIdLibro(libroDTO.getIdLibro());
        libro.setTitolo(libroDTO.getTitolo());
        libro.setAnno(libroDTO.getAnno());
        libro.setGenere(libroDTO.getGenere());
        return libro;
    }

    public GenereDTO convertGenereToGenereDTO (Genere genere) {
        GenereDTO genereDTO = new GenereDTO();
        genereDTO.setIdGenere(genere.getIdGenere());
        genereDTO.setNome(genere.getNome());
        return genereDTO;
    }

    public Genere convertGenereDTOToGenere (GenereDTO genereDTO) {
        Genere genere= new Genere();
        genere.setIdGenere(genereDTO.getIdGenere());
        genere.setNome(genereDTO.getNome());
        return genere;
    }

    public CopiaDTO convertCopiaToCopiaDTO (Copia copia) {
        CopiaDTO copiaDTO=new CopiaDTO();
        copiaDTO.setIdCopia(copia.getIdCopia());
        copiaDTO.setNumeroCopie(copia.getNumeroCopie());
        copiaDTO.setLibro(copia.getLibro());
        copiaDTO.setCasaEditrice(copia.getCasaEditrice());
        return copiaDTO;
    }
}
