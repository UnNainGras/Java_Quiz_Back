package com.takima.backskeleton.controllers;

import com.takima.backskeleton.DTO.QuestionDTO;
import com.takima.backskeleton.services.AdminService;
import com.takima.backskeleton.services.QuestionService;
import com.takima.backskeleton.models.Admin;
import com.takima.backskeleton.models.Question;
import com.takima.backskeleton.models.QuestionReponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionService questionService;
    private final AdminService adminService;

    @Autowired
    public QuestionController(QuestionService questionService, AdminService adminService) {
        this.questionService = questionService;
        this.adminService = adminService;
    }

    @GetMapping
    public List<QuestionDTO> getAllQuestions() {
        return questionService.toDTOs(questionService.findAllQuestions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionDTO> getQuestionById(@PathVariable Long id) {
        return questionService.findQuestionById(id)
                .map(question -> ResponseEntity.ok(questionService.toDTO(question)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<QuestionDTO> createQuestion(@RequestBody QuestionDTO questionDTO) {
        Admin admin = adminService.findAdminById(questionDTO.getAdminId())
                .orElseThrow(() -> new RuntimeException("Admin not found"));

        // Créer la question sans les réponses
        Question question = new Question(questionDTO.getQuestion(), questionDTO.getReponseCorrecte());
        question.setAdmin(admin);

        // Ajouter les réponses en utilisant la relation QuestionReponse
        List<QuestionReponse> questionReponses = questionDTO.getReponses().stream()
                .map(reponse -> new QuestionReponse(reponse, question))
                .collect(Collectors.toList());

        question.setQuestionReponses(questionReponses);

        // Sauvegarder la question
        QuestionDTO savedQuestionDTO = questionService.saveQuestion(question);
        return ResponseEntity.ok(savedQuestionDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
        return ResponseEntity.noContent().build();
    }
}
