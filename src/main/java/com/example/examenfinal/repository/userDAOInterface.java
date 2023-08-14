package com.example.examenfinal.repository;

import java.util.List;

public interface userDAOInterface {
    User insert(User to Insert);
    List<User> getAll();
    User getById(int Id);
}
