package com.example.dbmarket.service;

import com.example.dbmarket.entities.CategoryProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface CategoryProductService {
    public void save(CategoryProduct categoryProduct);

    public void deleteById(int categoryProductId);

    public List<CategoryProduct> findAll();

    public Optional<CategoryProduct> findById(int id);

    Page<CategoryProduct> findAll(Pageable pageable);
}
