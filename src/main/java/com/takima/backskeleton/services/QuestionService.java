package com.takima.backskeleton.services;

import com.takima.backskeleton.DTO.QuestionDTO;
import com.takima.backskeleton.models.Question;
import com.takima.backskeleton.models.QuestionReponse;
import com.takima.backskeleton.DAO.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuestionService {

    private final QuestionDao questionDao;

    @Autowired
    public QuestionService(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    // Récupérer toutes les questions
    public List<Question> findAllQuestions() {
        return questionDao.findAll();
    }

    // Trouver une question par ID
    public Optional<Question> findQuestionById(Long id) {
        return questionDao.findById(id);
    }

    // Sauvegarder une question et renvoyer un DTO
    public QuestionDTO saveQuestion(Question question) {
        Question savedQuestion = questionDao.save(question);
        return toDTO(savedQuestion);
    }

    // Supprimer une question par ID
    public void deleteQuestion(Long id) {
        questionDao.deleteById(id);
    }

    // Convertir une Question en QuestionDTO
    public QuestionDTO toDTO(Question question) {
        return new QuestionDTO(
                question.getId(),
                question.getQuestion(),
                question.getQuestionReponses().stream()
                        .map(QuestionReponse::getReponse)
                        .collect(Collectors.toList()),
                question.getReponseCorrecte(),
                question.getAdmin() != null ? question.getAdmin().getId() : null
        );
    }

    // Convertir une liste de questions en liste de DTOs
    public List<QuestionDTO> toDTOs(List<Question> questions) {
        return questions.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
