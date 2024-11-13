package com.takima.backskeleton.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;

    private String reponseCorrecte;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;  // Relation avec Admin

    // Nouvelle relation avec QuestionReponse
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<QuestionReponse> questionReponses;

    // Constructeur par défaut
    public Question() {}

    // Constructeur avec paramètres
    public Question(String question, String reponseCorrecte) {
        this.question = question;
        this.reponseCorrecte = reponseCorrecte;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getReponseCorrecte() {
        return reponseCorrecte;
    }

    public void setReponseCorrecte(String reponseCorrecte) {
        this.reponseCorrecte = reponseCorrecte;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<QuestionReponse> getQuestionReponses() {
        return questionReponses;
    }

    public void setQuestionReponses(List<QuestionReponse> questionReponses) {
        this.questionReponses = questionReponses;
    }
}
