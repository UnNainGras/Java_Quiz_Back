package com.takima.backskeleton.DTO;

public class QuestionDTO {
    private Long id;
    private String question;
    private String reponseCorrecte;

    // Constructeurs, Getters et Setters
    public QuestionDTO() {
    }

    public QuestionDTO(Long id, String question, String reponseCorrecte) {
        this.id = id;
        this.question = question;
        this.reponseCorrecte = reponseCorrecte;
    }

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
}
