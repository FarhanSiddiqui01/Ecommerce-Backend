package com.example.demo.service;

import com.example.demo.domain.Product;
import com.example.demo.domain.User;
import com.example.demo.exception.RecordNotFound;
import com.example.demo.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        if (presetById(id)){
            userRepository.deleteById(id);}else {
            throw new RecordNotFound(String.format("No User found on id => %d",id));
        }
    }

    public boolean presetById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return true;
        } else {
            return false;
        }

    }


    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }


    public Object update(User user, Long id) {
        if (presetById(id)) {
            User updateUser = getUserById(id).orElse(null);
            updateUser.setName(user.getName());
            updateUser.setEmail(user.getEmail());
            updateUser.setContact(user.getContact());
            updateUser.setCreatedAt(user.getCreatedAt());
            return ResponseEntity.ok(save(updateUser));
        }else{
            throw new RecordNotFound(String.format("No User found on id => %d",id));
        }
    }}
