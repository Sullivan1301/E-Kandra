package com.example.examenfinal.repository;

import com.example.examenfinal.entity.Category;
import org.springframework.cache.annotation.CacheAnnotationParser;

import java.util.List;

public interface CategoryDAOInterface {
    Category insert(Category category);
    List<Category> getAll();
    Category getById(int id);
}
