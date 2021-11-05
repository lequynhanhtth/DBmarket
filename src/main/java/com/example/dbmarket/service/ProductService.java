package com.example.dbmarket.service;

import com.example.dbmarket.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public List<Product> findAll();

    public void save (Product product);

    public void delete(int id);

    public Optional<Product> findById(int id);

    public boolean existById(int id);

    public List<Product> findTop10OrderByDate();

    public Page<Product> findByCategoryOrderByRate(String keyword, Pageable pageable);
}
