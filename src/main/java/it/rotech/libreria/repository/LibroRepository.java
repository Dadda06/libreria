package it.rotech.libreria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.rotech.libreria.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Integer> {

    List<Libro> findAllByTitoloContainingIgnoreCase(String titolo);

    //Tramite _ Spring capisce che deve entrare nella relazione che c'è con Genere
    List<Libro> findByGenere_NomeContainingIgnoreCase(String nomeGenere);

    @Query(value = """
        SELECT DISTINCT l.* FROM libro l
        JOIN libri_autori la ON l.id = la.fk_libro
        JOIN autore a ON la.fk_autore = a.id
        WHERE LOWER(a.nome) LIKE LOWER(CONCAT('%', :nome, '%'))
          AND LOWER(a.cognome) LIKE LOWER(CONCAT('%', :cognome, '%'))
        """, nativeQuery = true)
    List<Libro> findByAutoreNative(@Param("nome") String nome, @Param("cognome") String cognome);

    List<Libro> findByGenere_Id(Integer genereId);
}
