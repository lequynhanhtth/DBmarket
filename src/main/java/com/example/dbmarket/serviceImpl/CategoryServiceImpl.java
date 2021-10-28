package com.example.dbmarket.serviceImpl;

import com.example.dbmarket.entities.Category;
import com.example.dbmarket.entities.Customer;
import com.example.dbmarket.repository.CategoryRepository;
import com.example.dbmarket.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void delete(int id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Optional<Category> findById(int id) {
        return categoryRepository.findById(id);
    }

    @Override
    public boolean existById(int id) {
        return categoryRepository.existsById(id);
    }
}
