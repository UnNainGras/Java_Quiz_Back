package com.takima.backskeleton.services;

import com.takima.backskeleton.DTO.ScoreDTO;
import com.takima.backskeleton.models.Score;
import com.takima.backskeleton.DAO.ScoreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ScoreService {

    private final ScoreDao scoreDao;

    @Autowired
    public ScoreService(ScoreDao scoreDao) {
        this.scoreDao = scoreDao;
    }

    public List<Score> findAllScores() {
        return scoreDao.findAll();
    }

    public Optional<Score> findScoreById(Long id) {
        return scoreDao.findById(id);
    }

    public ScoreDTO saveScore(Score score) {
        Score savedScore = scoreDao.save(score);
        return toDTO(savedScore); // Convertir en ScoreDTO avant de retourner
    }

    public void deleteScore(Long id) {
        scoreDao.deleteById(id);
    }

    // Méthode de conversion vers ScoreDTO
    public ScoreDTO toDTO(Score score) {
        if (score.getUser() == null) {
            throw new RuntimeException("User is null for score ID: " + score.getId());
        }
        return new ScoreDTO(score.getId(), score.getScore(), score.getDate(), score.getUser().getId());
    }

    public List<ScoreDTO> toDTOs(List<Score> scores) {
        return scores.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
