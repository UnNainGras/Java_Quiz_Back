package com.takima.backskeleton.DTO;

public class UserDTO {
    private Long id;
    private String nom;
    private String email;

    // Constructeurs, Getters et Setters
    public UserDTO() {
    }

    public UserDTO(Long id, String nom, String email) {
        this.id = id;
        this.nom = nom;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}