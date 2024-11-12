package com.takima.backskeleton.models;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int score;

    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Constructeur par défaut
    public Score() {
    }

    // Constructeur avec paramètres
    public Score(int score, LocalDateTime date, User user) {
        this.score = score;
        this.date = date;
        this.user = user;
    }


    // Getters and Setters
    public Long getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public User getUser() {
        return user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setUser(User user) {
        this.user = user;
    }
}