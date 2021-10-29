package com.example.dbmarket.service;

import com.example.dbmarket.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public List<Product> findAll();

    public void save (Product product);

    public void delete(int id);

    public Optional<Product> findById(int id);

    public boolean existById(int id);

    public List<Product> findTop10OrderByDate();
}
