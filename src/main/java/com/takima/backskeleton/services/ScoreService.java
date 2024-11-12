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

    public Score saveScore(Score score) {
        return scoreDao.save(score);
    }

    public void deleteScore(Long id) {
        scoreDao.deleteById(id);
    }

    // Méthode de conversion vers ScoreDTO
    public ScoreDTO toDTO(Score score) {
        return new ScoreDTO(score.getId(), score.getScore());
    }

    public List<ScoreDTO> toDTOs(List<Score> scores) {
        return scores.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public Optional<Score> findScoreById(Long id) {
        return scoreDao.findById(id);
    }

}
