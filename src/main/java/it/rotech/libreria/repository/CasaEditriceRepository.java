package it.rotech.libreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.rotech.libreria.model.CasaEditrice;
import java.util.List;


public interface CasaEditriceRepository extends JpaRepository <CasaEditrice, Integer> {
    List<CasaEditrice>  findAllByNome(String nome);

}
