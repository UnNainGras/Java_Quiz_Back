package com.takima.backskeleton.DTO;

public class ScoreDTO {
    private Long id;
    private int score;

    // Constructeurs, Getters et Setters
    public ScoreDTO() {
    }

    public ScoreDTO(Long id, int score) {
        this.id = id;
        this.score = score;
    }

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
}
