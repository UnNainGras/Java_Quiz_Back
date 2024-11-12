// src/main/java/com/takima/backskeleton/models/Answer.java
package com.takima.backskeleton.models;

import jakarta.persistence.*;

@Entity
@Table(name = "answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String text;

    @Column(name = "is_correct")
    private boolean isCorrect;

    // Constructeur par défaut
    public Answer() {}

    // Constructeur avec Builder
    private Answer(Builder builder) {
        this.id = builder.id;
        this.text = builder.text;
        this.isCorrect = builder.isCorrect;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    // Builder Pattern
    public static class Builder {
        private Long id;
        private String text;
        private boolean isCorrect;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder text(String text) {
            this.text = text;
            return this;
        }

        public Builder isCorrect(boolean isCorrect) {
            this.isCorrect = isCorrect;
            return this;
        }

        public Answer build() {
            return new Answer(this);
        }
    }
}
