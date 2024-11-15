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

@CrossOrigin
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

    /**
     * Récupère toutes les questions sous forme de DTO.
     */
    @GetMapping
    public List<QuestionDTO> getAllQuestions() {
        return questionService.toDTOs(questionService.findAllQuestions());
    }

    /**
     * Récupère une question par ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<QuestionDTO> getQuestionById(@PathVariable Long id) {
        return questionService.findQuestionById(id)
                .map(question -> ResponseEntity.ok(questionService.toDTO(question)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Crée une nouvelle question avec les réponses associées.
     */
    @PostMapping
    public ResponseEntity<QuestionDTO> createQuestion(@RequestBody QuestionDTO questionDTO) {
        // Récupérer l'admin à partir de son ID
        Admin admin = adminService.findAdminById(questionDTO.getAdminId())
                .orElseThrow(() -> new RuntimeException("Admin not found"));

        // Créer une nouvelle question
        Question question = new Question(questionDTO.getQuestion(), questionDTO.getReponseCorrecte());
        question.setAdmin(admin);

        // Ajouter les réponses en utilisant la relation QuestionReponse
        List<QuestionReponse> questionReponses = questionDTO.getReponses().stream()
                .map(reponse -> new QuestionReponse(reponse, question))
                .collect(Collectors.toList());

        // Associer les réponses à la question
        question.setQuestionReponses(questionReponses);

        // Sauvegarder la question et retourner le DTO correspondant
        QuestionDTO savedQuestionDTO = questionService.saveQuestion(question);
        return ResponseEntity.ok(savedQuestionDTO);
    }

    /**
     * Supprime une question par ID.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
        return ResponseEntity.noContent().build();
    }
}
