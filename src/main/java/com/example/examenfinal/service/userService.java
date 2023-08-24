package com.example.examenfinal.service;

import java.sql.SQLException;
import java.util.List;

import com.example.examenfinal.repository.UserDAOInterface;
import org.springframework.stereotype.Service;
import com.example.examenfinal.entity.user;
import com.example.examenfinal.repository.userDAO;

@Service
public class userService{

    private static UserDAOInterface dao;

    public userService(UserDAOInterface dao){
        this.dao = dao;
    }

    public static user createUser(user User){
        return dao.insert(User);
    }

    public static List<user> getAllUser() throws SQLException{
        return dao.getAll();
    }

    public static user getUserByID(int id){
        return dao.getById(id);
    }

    public static void updateUser(user User){
        dao.update(User);
    }

    public static void deleteUser(int id){
        dao.delete(id);
    }
}
