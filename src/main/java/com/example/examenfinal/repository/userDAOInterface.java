package com.example.examenfinal.repository;

import java.sql.SQLException;
import java.util.List;

public interface userDAOInterface {
    user insert(user toInsert);
    List<user> getAll() throws SQLException;
    user getById(int Id);
}
