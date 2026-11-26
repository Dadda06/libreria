package it.rotech.libreria.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import io.jsonwebtoken.Jwt;
import it.rotech.libreria.jwt.JwtFilter;
import it.rotech.libreria.service.AuthService;
import it.rotech.libreria.service.JwtService;
import it.rotech.libreria.service.LoginService;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration 
@EnableWebSecurity 
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http,JwtFilter jwtFilter) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) 

            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/autenticazione/**")
                .permitAll()
                .anyRequest()
                .authenticated() 
            )
            // Autorizzo le autenticazioni tramite Form HTML.

            // Abilito l'autenticazione Basic HTTP
            .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )
            // Prima di andare avanti, passo per il filtro Jwt per vedere se la mia richiesta HTTP ha un token valido.
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
            // L'autenticazione ce lha il client
            
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean 
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration)throws Exception{
        return configuration.getAuthenticationManager();
    }
 
    /**
     * Metodo che crea un utente admin e lo salva in memoria RAM.
     * @param passwordEncoder il tipo di password encoder da utilizzare. Spring Security inietterà il Bean dichiarato sopra, che utilizza il BCrypt.
     */
    // @Bean
    // public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
    //     UserDetails admin = User.builder()
    //         .username("admin")
    //         .password(passwordEncoder.encode("password123")) 
    //         .roles("ADMIN")
    //         .build();

    //     return new InMemoryUserDetailsManager(admin);
    // }

    /*
     Per usare il database come persistenza per cercare l'utente, si usa il Data Access Object (DAO).
     Il DAO permette di comunicare con il mondo esterno a Java (in questo caso con MySQL).
     La classe che permette di configurare l'autenticazione tramite DAO si chiama DaoAuthenticationProvider. 
     Per poter loggare un utente, usiamo username e password.
     La classe che Spring Security usa per gli utenti con usenrame e password è UserDetails.
     La logica dietro le operazioni, quali "getUserByUsername", va implementata eseguendo l'override del metodo "loadUserByUsername()",
     contenuta come unico metodo all'interno di UserDetailsService.


     */
    // Scrivi qui il DAO per poter configurare l'autenticazione tramite database.
    @Bean 
    public DaoAuthenticationProvider daoAuthenticationProvider (AuthService authService, PasswordEncoder passwordEncoder){
        // Creo un oggetto DaoAuthenticationProvider settando tramite costruttore tramite l'oggetto UserDetails usando loadUserByUsername().
        DaoAuthenticationProvider dao = new DaoAuthenticationProvider(authService);
        dao.setPasswordEncoder(passwordEncoder);
        return dao;

    }
    // Dopo che hai implementato il DAO, fai in modo che sia il Client a ricordarsi chi è e se è autenticato o meno.
    //  Fallo attraverso il Jwt, quindi la logica falla in un JwtService. Tuttavia, fai dei controlli prima di chiamare JwtService
    // attraverso una classe Filtro (chiamala JwtFiltro oppure JwtAuthenticationFilter, che inietterà il service Jwt e il tuo LoginService per poter loggare l'utente.)
 
    @Bean 
    public JwtFilter filtroJwt (AuthService authService, JwtService jwtService){
        return new JwtFilter(authService,jwtService);

    }

}