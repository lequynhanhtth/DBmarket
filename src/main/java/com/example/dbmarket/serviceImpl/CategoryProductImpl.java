package com.example.dbmarket.serviceImpl;

import com.example.dbmarket.entities.CategoryProduct;
import com.example.dbmarket.repository.CategoryProductRepository;
import com.example.dbmarket.service.CategoryProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CategoryProductImpl implements CategoryProductService {
    @Autowired
    CategoryProductRepository categoryProductRepository;
    @Override
    public void save(CategoryProduct categoryProduct) {
        categoryProductRepository.save(categoryProduct);
    }

    @Override
    public void deleteById(int categoryProductId) {
        categoryProductRepository.deleteById(categoryProductId);
    }

    @Override
    public List<CategoryProduct> findAll() {
        return categoryProductRepository.findAll();
    }

    @Override
    public Optional<CategoryProduct> findById(int id) {
        return categoryProductRepository.findById(id);
    }

    @Override
    public Page<CategoryProduct> findAll(Pageable pageable) {
        return categoryProductRepository.findAll(pageable);
    }
}
