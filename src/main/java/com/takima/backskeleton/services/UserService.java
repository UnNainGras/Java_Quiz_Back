package com.takima.backskeleton.services;

import com.takima.backskeleton.DTO.UserDTO;
import com.takima.backskeleton.models.User;
import com.takima.backskeleton.DAO.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> findAllUsers() {
        return userDao.findAll();
    }

    public Optional<User> findUserById(Long id) {
        return userDao.findById(id);
    }

    // Méthode pour sauvegarder un utilisateur
    public User saveUser(User user) {
        return userDao.save(user);
    }

    public void deleteUser(Long id) {
        userDao.deleteById(id);
    }

    // Méthodes de conversion vers DTO
    public UserDTO toDTO(User user) {
        return new UserDTO(user.getId(), user.getNom(), user.getEmail());
    }

    public List<UserDTO> toDTOs(List<User> users) {
        return users.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
