package it.rotech.libreria.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="Utenti") 
public class Login {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name="id")
    private Integer id;
    @Column (name="username")
    private String username;
    @Column (name="password")
    private String password;

    public Login (){}

    public Login (String username, String password){
        this.username=username;
        this.password=password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername (String username) {
        this.username=username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword (String password) {
        this.password=password;
    }

    public Integer getId() {
        return id;
    }
}
