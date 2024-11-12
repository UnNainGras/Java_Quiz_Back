package com.takima.backskeleton.DAO;

import com.takima.backskeleton.models.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreDao extends JpaRepository<Score, Long>  {
// Méthodes supplémentaires si nécessaire
}
