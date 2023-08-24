package com.example.examenfinal.service;

import java.sql.SQLException;
import java.util.List;

import com.example.examenfinal.repository.UserDAOInterface;
import org.springframework.stereotype.Service;
import com.example.examenfinal.entity.user;
import com.example.examenfinal.repository.userDAO;

@Service
public class userService{

    public userService(UserDAOInterface userDAO){
    }

    public static user createUser(user User){
        return userDAO.insert(User);
    }

    public static List<user> getAllUser() throws SQLException{
        return userDAO.getAll();
    }

    public static user getUserByID(int id){
        return userDAO.getById(id);
    }

    public static void updateUser(user User){
        userDAO.update(User);
    }

    public static void deleteUser(int id){
        userDAO.delete(id);
    }
}
