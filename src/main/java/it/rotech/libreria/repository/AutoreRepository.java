package it.rotech.libreria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.rotech.libreria.model.Autore;

public interface AutoreRepository extends JpaRepository <Autore, Integer> {
    List<Autore> findAllByNomeAndCognome(String nome, String cognome);

    @Modifying
    @Query(value = """
          DELETE FROM Libri_Autori WHERE Libri_Autori.fk_autore = :idAutore
      """, nativeQuery = true)
    void deleteAutoreFromLibriAutori(@Param ("idAutore") Integer id);
}
