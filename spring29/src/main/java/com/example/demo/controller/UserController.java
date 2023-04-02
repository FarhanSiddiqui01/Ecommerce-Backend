package com.example.demo.controller;

import com.example.demo.domain.Category;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/save")
    public ResponseEntity<User> save(@RequestBody User user){
        return ResponseEntity.ok(userService.save(user));}

    @GetMapping("/get")
    public List<User> getAllUser(){
        return userService.getAll();}

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id,@RequestBody User user){
            return ResponseEntity.ok(userService.update(user,id));
        }

    }


