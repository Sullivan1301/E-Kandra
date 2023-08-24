package com.example.examenfinal.repository;

import java.sql.SQLException;
import java.util.List;
import com.example.examenfinal.entity.user;

public interface UserDAOInterface {
    user insert(user User);
    List<user> getAll() throws SQLException;
    user getById(int id);
    void update (user User);
    void delete (int id);
}
