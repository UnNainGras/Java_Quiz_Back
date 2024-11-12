package com.takima.backskeleton.DAO;


import com.takima.backskeleton.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminDao extends JpaRepository<Admin, Long> {
// Méthodes supplémentaires si nécessaire
}
