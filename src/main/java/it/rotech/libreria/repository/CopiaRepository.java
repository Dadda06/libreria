package it.rotech.libreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.rotech.libreria.model.Copia;
import it.rotech.libreria.model.Libro;

public interface CopiaRepository extends JpaRepository <Copia, Integer> {
    void deleteByLibro (Libro libro);
}
