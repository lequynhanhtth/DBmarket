package com.example.dbmarket.service;

import com.example.dbmarket.entities.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findAll();

    void save(Category category);

    void delete(int id);

    Optional<Category> findById(int id);

    boolean existById(int id);

    Page<Category> findAdd(Pageable pageable);
}
