package it.rotech.libreria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.rotech.libreria.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Integer> {

    List<Libro> findByTitoloContainingIgnoreCase(String titolo);
}
