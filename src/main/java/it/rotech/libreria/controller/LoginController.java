package it.rotech.libreria.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.rotech.libreria.dto.LoginDTO;
import it.rotech.libreria.dto.Request.LoginRequest;
import it.rotech.libreria.service.LoginService;

@RestController 
@RequestMapping ("/autenticazione")
public class LoginController {
    private LoginService loginService;

    public LoginController (LoginService loginService){
        this.loginService=loginService;
    }

    @PostMapping ("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest richiesta){
        // System.out.println(loginService.login(richiesta));
        return ResponseEntity.ok(loginService.login(richiesta));
    }
    @PostMapping ("/register")
    public ResponseEntity<LoginDTO> register(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(loginService.register(loginRequest));
    }

    @GetMapping("/test")
    public String testAutenticazione() {
        return "Evviva! Sei riuscito a fare il login e vedere questa pagina protetta!";
    }
}
