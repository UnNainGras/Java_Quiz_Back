package com.takima.backskeleton.DTO;

import java.time.LocalDateTime;

public class ScoreDTO {
    private Long id;
    private int score;
    private LocalDateTime date;
    private Long userId; // Remplace l'objet User par son identifiant

    // Constructeurs, Getters et Setters
    public ScoreDTO() {}

    public ScoreDTO(Long id, int score, LocalDateTime date, Long userId) {
        this.id = id;
        this.score = score;
        this.date = date;
        this.userId = userId;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
