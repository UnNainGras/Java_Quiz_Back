package com.takima.backskeleton.controllers;

import com.takima.backskeleton.DTO.ScoreDTO;
import com.takima.backskeleton.services.ScoreService;
import com.takima.backskeleton.models.Score;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scores")
public class ScoreController {

    private final ScoreService scoreService;

    @Autowired
    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @GetMapping
    public List<ScoreDTO> getAllScores() {
        return scoreService.toDTOs(scoreService.findAllScores());
    }

    @PostMapping
    public ScoreDTO createScore(@Valid @RequestBody Score score) {
        return scoreService.toDTO(scoreService.saveScore(score));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScore(@PathVariable Long id) {
        scoreService.deleteScore(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScoreDTO> getScoreById(@PathVariable Long id) {
        return scoreService.findScoreById(id)
                .map(score -> ResponseEntity.ok(scoreService.toDTO(score)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }



}
