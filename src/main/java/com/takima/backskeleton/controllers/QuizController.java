package com.takima.backskeleton.controllers;

import com.takima.backskeleton.DTO.QuestionDTO;
import com.takima.backskeleton.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/quiz") // Assurez-vous que ce mapping est correct
public class QuizController {

    private final QuestionService questionService;

    @Autowired
    public QuizController(QuestionService questionService) {
        this.questionService = questionService;
    }

    /**
     * Endpoint pour récupérer toutes les questions et leurs réponses pour le quiz.
     */
    @GetMapping
    public List<QuestionDTO> getQuizQuestions() {
        return questionService.toDTOs(questionService.findAllQuestions());
    }
}
