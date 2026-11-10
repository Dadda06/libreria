package it.rotech.libreria.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import it.rotech.libreria.model.Genere;

public interface GenereRepository extends JpaRepository<Genere, Integer> {

    Genere findByNomeContainingIgnoreCase(String nomeG);
    

}
