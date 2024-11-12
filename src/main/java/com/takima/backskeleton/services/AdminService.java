package com.takima.backskeleton.services;

import com.takima.backskeleton.DTO.AdminDTO;
import com.takima.backskeleton.models.Admin;
import com.takima.backskeleton.DAO.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminService {

    private final AdminDao adminDao;

    @Autowired
    public AdminService(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    public List<Admin> findAllAdmins() {
        return adminDao.findAll();
    }

    public Optional<Admin> findAdminById(Long id) {
        return adminDao.findById(id);
    }

    public Admin saveAdmin(Admin admin) {
        return adminDao.save(admin);
    }

    public void deleteAdmin(Long id) {
        adminDao.deleteById(id);
    }

    // Méthode de conversion vers AdminDTO
    public AdminDTO toDTO(Admin admin) {
        return new AdminDTO(admin.getId(), admin.getNom(), admin.getEmail());
    }

    public List<AdminDTO> toDTOs(List<Admin> admins) {
        return admins.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
