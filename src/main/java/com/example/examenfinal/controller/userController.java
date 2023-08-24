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
    }

    @PostMapping("/create")
    public user createUser(@RequestBody user user) {
        return userService.createUser(user);
    }

    @GetMapping("/all")
    public List<user> getAllUser() throws SQLException {
        return userService.getAllUser();
    }

    @GetMapping("/{userId}")
    public user getUserById(@PathVariable int userId) {
        return userService.getUserByID(userId);
    }

    @PutMapping("/update")
    public void updateUser(@RequestBody user User) {
        userService.updateUser(User);
    }

    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
    }
}
