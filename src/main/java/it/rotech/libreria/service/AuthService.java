package it.rotech.libreria.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import it.rotech.libreria.exception.LoginNotFoundException;
import it.rotech.libreria.model.Login;
import it.rotech.libreria.repository.LoginRepository;

@Service 
public class AuthService implements UserDetailsService {

    private final LoginRepository loginRepository;

    public AuthService (LoginRepository loginRepository){
        this.loginRepository=loginRepository;
    }

        @Override
    public UserDetails loadUserByUsername(String username)  {
        //cerco se esiste nel database lo user e assegno a user L'UTENTE nel DB
        //E verifico se lo user è esistente nel DB
        Login utente=loginRepository.findByUsername(username). orElseThrow(()-> new LoginNotFoundException("Non sei registrato"));
        //devo definire che è un UserDetails perché quello stronzo del DAO lo vuole
        UserDetails userD = User.builder().username(utente.getUsername()).password(utente.getPassword()).build();
        return userD;

    }
    

}
