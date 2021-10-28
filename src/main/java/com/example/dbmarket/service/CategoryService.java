package com.example.dbmarket.service;

import com.example.dbmarket.entities.Category;
import com.example.dbmarket.entities.Customer;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    public List<Category> findAll();

    public void save (Category category);

    public void delete(int id);

    public Optional<Category> findById(int id);

    public boolean existById(int id);
}
