package com.takima.backskeleton.DTO;

import java.util.List;

public class QuestionDTO {
    private Long id;
    private String question;
    private List<String> reponses;
    private String reponseCorrecte;
    private Long adminId;

    // Constructeur par défaut
    public QuestionDTO() {}

    // Constructeur avec paramètres
    public QuestionDTO(Long id, String question, List<String> reponses, String reponseCorrecte, Long adminId) {
        this.id = id;
        this.question = question;
        this.reponses = reponses;
        this.reponseCorrecte = reponseCorrecte;
        this.adminId = adminId;
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

    public List<String> getReponses() {
        return reponses;
    }

    public void setReponses(List<String> reponses) {
        this.reponses = reponses;
    }

    public String getReponseCorrecte() {
        return reponseCorrecte;
    }

    public void setReponseCorrecte(String reponseCorrecte) {
        this.reponseCorrecte = reponseCorrecte;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }
}
