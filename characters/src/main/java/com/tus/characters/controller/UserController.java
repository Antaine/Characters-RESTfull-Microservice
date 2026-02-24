package com.tus.characters.controller;

import com.tus.characters.entity.User;
import com.tus.characters.service.impl.UserServiceImpl;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users") // <-- this makes /api/users available
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }
    
    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Character> characters = new ArrayList<>();
}