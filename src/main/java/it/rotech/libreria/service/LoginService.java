package it.rotech.libreria.service;

import org.jspecify.annotations.Nullable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwt;
import it.rotech.libreria.dto.LoginDTO;
import it.rotech.libreria.dto.Request.LoginRequest;
import it.rotech.libreria.exception.LoginNotFoundException;
import it.rotech.libreria.model.Login;
import it.rotech.libreria.repository.LoginRepository;

@Service 
public class LoginService {

    private final LoginRepository loginRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    public LoginService (LoginRepository loginRepository,AuthenticationManager authenticationManager,PasswordEncoder passwordEncoder,JwtService jwtService){
        this.loginRepository=loginRepository;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    // public boolean verificaLogin(String username, String passwordInserita){
    //     // Login utenteTrovato= loginRepository.findByUsername(username);
        
    //     if(utenteTrovato == null){
    //         return false;
    //     }

    //     if(utenteTrovato.getPassword().equals(passwordInserita)){
    //         return true;
    //     }
    //     return false;
    // }



    public String login(LoginRequest richiesta) {
        // TODO Auto-generated method stub
        Authentication authentication = new UsernamePasswordAuthenticationToken(richiesta.getUsername(), richiesta.getPassword());
        authenticationManager.authenticate(authentication);
        return jwtService.generaToken(authentication.getName());
    }
    public LoginDTO register(LoginRequest loginRequest){
        Login login = loginRepository.save(
            new Login(
                loginRequest.getUsername(),
                passwordEncoder.encode(loginRequest.getPassword()
            )));
        LoginDTO loginDTOret = new LoginDTO();
        loginDTOret.setId(login.getId());
        loginDTOret.setUsername(login.getUsername());
        loginDTOret.setPassword(login.getPassword());
        return loginDTOret;
    }
   
}
