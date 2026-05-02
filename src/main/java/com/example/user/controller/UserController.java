package com.example.user.controller;

import com.example.user.entity.User;
import com.example.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public User createUser(@RequestBody User user) {
        return service.createUser(user);
    }

    // READ ALL
    @GetMapping
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return service.getUserById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return service.updateUser(id, user);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return "User deleted successfully";
    }
}