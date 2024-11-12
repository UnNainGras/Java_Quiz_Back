package com.takima.backskeleton.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;

    @ElementCollection
    private List<String> reponses;

    private String reponseCorrecte;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    // Constructeur par défaut
    public Question() {
    }

    // Constructeur avec paramètres
    public Question(String question, List<String> reponses, String reponseCorrecte) {
        this.question = question;
        this.reponses = reponses;
        this.reponseCorrecte = reponseCorrecte;
    }


    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getReponses() {
        return reponses;
    }

    public String getReponseCorrecte() {
        return reponseCorrecte;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setReponses(List<String> reponses) {
        this.reponses = reponses;
    }

    public void setReponseCorrecte(String reponseCorrecte) {
        this.reponseCorrecte = reponseCorrecte;
    }

}
