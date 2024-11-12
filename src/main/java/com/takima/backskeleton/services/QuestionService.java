package com.takima.backskeleton.services;

import com.takima.backskeleton.DTO.QuestionDTO;
import com.takima.backskeleton.models.Question;
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

    public List<Question> findAllQuestions() {
        return questionDao.findAll();
    }

    public Optional<Question> findQuestionById(Long id) {
        return questionDao.findById(id);
    }

    public Question saveQuestion(Question question) {
        return questionDao.save(question);
    }

    public void deleteQuestion(Long id) {
        questionDao.deleteById(id);
    }

    // Méthode de conversion vers QuestionDTO
    public QuestionDTO toDTO(Question question) {
        return new QuestionDTO(question.getId(), question.getQuestion(), question.getReponseCorrecte());
    }

    public List<QuestionDTO> toDTOs(List<Question> questions) {
        return questions.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
