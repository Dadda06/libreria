package it.rotech.libreria.jwt;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import it.rotech.libreria.service.AuthService;
import it.rotech.libreria.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtFilter extends OncePerRequestFilter {

    private final AuthService authService;
    private final JwtService jwtService;

    public JwtFilter(AuthService authService, JwtService jwtService) {
        this.authService = authService;
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // devi far leggere l'header dell'autorizzatione (controllare se inizia con
        // "Bearer")
        String header = request.getHeader("Authorization");
        if (header == null || !header.startsWith("Bearer ")) {
            // Vai avanti con la catena, esempio:
            // se per esempio l'utente semplicemente ha un token scaduto, generagliene uno vuoto.
            filterChain.doFilter(request, response);
            return;
        }

        String token = header.substring(7);
        if (jwtService.validaToken(token)) {
            // Se il token è valido, devo prenderlo
            String usernameFromToken = jwtService.estraiUsername(token);
            //carico l'utente dal DB
            UserDetails utente = authService.loadUserByUsername(usernameFromToken);
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                usernameFromToken, 
                null, 
                utente.getAuthorities()
            );
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }

        filterChain.doFilter(request, response);

    }

}
