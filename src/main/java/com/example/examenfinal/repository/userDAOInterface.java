package com.example.examenfinal.repository;

import java.sql.SQLException;
import java.util.List;
import com.example.examenfinal.entity.User;

public interface UserDAOInterface {
    User insert(User toInsert);
    List<User> getAll() throws SQLException;
    User getById(int id);
}
