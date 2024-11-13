package com.takima.backskeleton.controllers;

import com.takima.backskeleton.DTO.ScoreDTO;
import com.takima.backskeleton.services.ScoreService;
import com.takima.backskeleton.models.Score;
import com.takima.backskeleton.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scores")
public class ScoreController {

    private final ScoreService scoreService;
    private final UserService userService;

    @Autowired
    public ScoreController(ScoreService scoreService, UserService userService) {
        this.scoreService = scoreService;
        this.userService = userService;
    }

    @GetMapping
    public List<ScoreDTO> getAllScores() {
        return scoreService.toDTOs(scoreService.findAllScores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScoreDTO> getScoreById(@PathVariable Long id) {
        return scoreService.findScoreById(id)
                .map(score -> ResponseEntity.ok(scoreService.toDTO(score)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ScoreDTO> createScore(@RequestBody ScoreDTO scoreDTO) {
        Score score = new Score();
        score.setScore(scoreDTO.getScore());
        score.setDate(scoreDTO.getDate());

        // Associe l'utilisateur par son ID si l'utilisateur existe
        userService.findUserById(scoreDTO.getUserId())
                .ifPresentOrElse(score::setUser,
                        () -> { throw new RuntimeException("User not found"); });

        // saveScore renvoie maintenant un ScoreDTO directement
        ScoreDTO savedScoreDTO = scoreService.saveScore(score);
        return ResponseEntity.ok(savedScoreDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScore(@PathVariable Long id) {
        scoreService.deleteScore(id);
        return ResponseEntity.noContent().build();
    }
}
