package com.takima.backskeleton.controllers;

import com.takima.backskeleton.DTO.QuestionDTO;
import com.takima.backskeleton.services.QuestionService;
import com.takima.backskeleton.models.Question;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
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
    public QuestionDTO createQuestion(@Valid @RequestBody Question question) {
        return questionService.toDTO(questionService.saveQuestion(question));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
        return ResponseEntity.noContent().build();
    }
}
