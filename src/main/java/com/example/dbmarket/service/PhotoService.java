package com.example.dbmarket.service;

import com.example.dbmarket.entities.Photo;
import com.example.dbmarket.entities.Product;

import java.util.List;
import java.util.Optional;

public interface PhotoService {
    public List<Photo> findAll();

    public void save (Photo photo);

    public void delete(int id);

    public Optional<Photo> findById(int id);

    public boolean existById(int id);

    public List<Photo> findByProductId(int id);
}
