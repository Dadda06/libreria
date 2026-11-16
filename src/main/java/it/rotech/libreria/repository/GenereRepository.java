package it.rotech.libreria.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.rotech.libreria.model.Genere;

public interface GenereRepository extends JpaRepository<Genere, Integer> {

    Optional<Genere> findByNomeIgnoreCase(String nomeG);
    List <Genere> findAllByNome(String nome);
    

}
