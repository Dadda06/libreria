package it.rotech.libreria.service;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service 
public class JwtService {
    //devo creare un algoritmo che genera una chiave segreta 
    private final SecretKey KEY = Keys.hmacShaKeyFor("LaMiaPasswordIncredibilmenteLungaESicura".getBytes());
    private final Integer DURATA = 1800000;


    public String generaToken (String username){
    return Jwts.builder()
        .issuedAt(new Date(System.currentTimeMillis()))
        .expiration(new Date(System.currentTimeMillis()+DURATA))
        .subject(username)
        .signWith(KEY)
        .compact();

    }

    public boolean validaToken (String token){
        return !generaToken(token).isEmpty();
    }

    public String estraiUsername (String token){
        return Jwts.parser()
        // Verifica che il token sia stato generato con la chiave KEY
        .verifyWith(KEY)
        // Dal JwtParserBuilder mi genera un JwtParser SOLO se è stato verificato
        .build()
        // Dal Token, parsami i vari Claims (Header,Payload,Signature)
        .parseSignedClaims(token)
        // Prendimi solo il Payload (parte centrale)
        .getPayload()
        // Estraimi il subject, ovvero chi è l'utente.
        .getSubject();
    }
}
