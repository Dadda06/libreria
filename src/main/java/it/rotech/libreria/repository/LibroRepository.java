package it.rotech.libreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.rotech.libreria.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Integer> {
    

}
