package it.rotech.libreria.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.rotech.libreria.dto.Request.LoginRequest;
import it.rotech.libreria.service.LoginService;

@RestController 
//@RequestMapping ("/login")
public class LoginController {
    /*private LoginService loginService;

    public LoginController (LoginService loginService){
        this.loginService=loginService;
    }

    @PostMapping 
    public ResponseEntity<String> login(@RequestBody LoginRequest richiesta){
        boolean successo = loginService.verificaLogin(richiesta.getUsername(),richiesta.getPassword());

        if(successo){
            return ResponseEntity.ok("Login effettuato");
        }else{
            return ResponseEntity.status(401).body("Credenziali non valide");
        }
    }*/

    @GetMapping("/test")
    public String testAutenticazione() {
        return "Evviva! Sei riuscito a fare il login e vedere questa pagina protetta!";
    }
}
