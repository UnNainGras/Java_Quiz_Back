package com.takima.backskeleton.models;

import jakarta.validation.constraints.NotNull;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "users", schema = "public")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Size(min = 6)
    private String motDePasse;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Score> scores;

    // Constructeur par défaut
    public User() {
    }

    // Constructeur avec paramètres
    public User(String nom, String email, String motDePasse) {
        this.nom = nom;
        this.email = email;
        this.motDePasse = motDePasse;
    }


    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public List<Score> getScores() {
        return scores;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }
}
