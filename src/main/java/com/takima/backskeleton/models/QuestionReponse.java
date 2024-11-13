package com.takima.backskeleton.models;

import jakarta.persistence.*;

@Entity
@Table(name = "question_reponses")
public class QuestionReponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reponse;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    // Constructeur par défaut
    public QuestionReponse() {}

    // Constructeur avec paramètres pour la réponse et la question
    public QuestionReponse(String reponse, Question question) {
        this.reponse = reponse;
        this.question = question;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
