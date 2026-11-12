package it.rotech.libreria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.rotech.libreria.model.Autore;

public interface AutoreRepository extends JpaRepository <Autore, Integer> {
    List<Autore> findAllByNomeAndCognome(String nome, String cognome);
}
