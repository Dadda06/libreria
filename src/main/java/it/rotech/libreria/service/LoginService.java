package it.rotech.libreria.service;

import org.springframework.stereotype.Service;

import it.rotech.libreria.model.Login;
import it.rotech.libreria.repository.LoginRepository;

@Service 
public class LoginService {

    private final LoginRepository loginRepository;

    public LoginService (LoginRepository loginRepository){
        this.loginRepository=loginRepository;
    }

    public boolean verificaLogin(String username, String passwordInserita){
        Login utenteTrovato= loginRepository.findByUsername(username);
        
        if(utenteTrovato == null){
            return false;
        }

        if(utenteTrovato.getPassword().equals(passwordInserita)){
            return true;
        }
        return false;
    }

}
