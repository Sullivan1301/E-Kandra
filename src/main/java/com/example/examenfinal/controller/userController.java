package com.example.examenfinal.controller;

import java.sql.SQLException;
import java.util.List;

import com.example.examenfinal.service.userService;
import org.springframework.web.bind.annotation.*;
import com.example.examenfinal.entity.user;
import com.example.examenfinal.service.userService;

@RestController
@RequestMapping("/users")
public class userController {
    private userService UserService;

    public userController(userService UserService) {
        this.UserService = UserService;
    }

    @PostMapping("/create")
    public user createUser(@RequestBody user User) {
        return userService.createUser(User);
    }

    @GetMapping("/all")
    public List<user> getAllUser() throws SQLException {
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public user getUserById(@PathVariable int id) {
        return userService.getUserByID(id);
    }

    @PutMapping("/id")
    public void updateUser(@PathVariable int id, @RequestBody user User) {
        userService.updateUser(User);
    }

    @DeleteMapping("/id")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
}
