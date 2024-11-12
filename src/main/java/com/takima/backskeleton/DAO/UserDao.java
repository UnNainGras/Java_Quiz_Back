package com.takima.backskeleton.DAO;


import com.takima.backskeleton.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<User, Long> {
    Optional<Object> findByEmail(String email);
// Méthodes supplémentaires si nécessaire
}
