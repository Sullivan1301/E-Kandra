package com.example.examenfinal.repository;

import com.example.examenfinal.entity.Domain;

import java.util.List;

public interface DomainDAOInterface {
    Domain insert(Domain domain);
    List<Domain> getAll();
    Domain getById(int id);
}
