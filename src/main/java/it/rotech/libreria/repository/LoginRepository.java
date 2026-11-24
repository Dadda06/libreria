package it.rotech.libreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.rotech.libreria.model.Login;


public interface LoginRepository extends JpaRepository<Login, Integer>{

    Login findByUsername(String username);

}
