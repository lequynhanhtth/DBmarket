package com.example.dbmarket.service;

import com.example.dbmarket.entities.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findAll();

    void save(Category category);

    void delete(int id);

    Optional<Category> findById(int id);

    boolean existById(int id);
}