package com.example.dbmarket.serviceImpl;

import com.example.dbmarket.entities.Category;
import com.example.dbmarket.entities.Customer;
import com.example.dbmarket.repository.CategoryRepository;
import com.example.dbmarket.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
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

    @Override
    public Page<Category> findAdd(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }
}
