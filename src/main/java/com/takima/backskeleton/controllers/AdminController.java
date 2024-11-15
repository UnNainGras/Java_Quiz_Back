package com.takima.backskeleton.controllers;

import com.takima.backskeleton.DTO.AdminDTO;
import com.takima.backskeleton.services.AdminService;
import com.takima.backskeleton.models.Admin;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/admins")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public List<AdminDTO> getAllAdmins() {
        return adminService.toDTOs(adminService.findAllAdmins());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminDTO> getAdminById(@PathVariable Long id) {
        return adminService.findAdminById(id)
                .map(admin -> ResponseEntity.ok(adminService.toDTO(admin)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public AdminDTO createAdmin(@Valid @RequestBody Admin admin) {
        return adminService.toDTO(adminService.saveAdmin(admin));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
        if (adminService.findAdminById(id).isPresent()) {
            adminService.deleteAdmin(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
