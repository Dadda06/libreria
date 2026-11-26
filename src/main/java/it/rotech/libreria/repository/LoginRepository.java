package it.rotech.libreria.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.rotech.libreria.model.Login;


public interface LoginRepository extends JpaRepository<Login, Integer>{

    Optional<Login> findByUsername(String username);

}
