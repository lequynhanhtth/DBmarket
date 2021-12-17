package com.example.dbmarket.service;

import com.example.dbmarket.entities.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface BrandService {
    public void save(Brand brand);

    public List<Brand> findAll();

    public void deleteById(int brandId);

    public Optional<Brand> findById(int brandId);

    public Page<Brand> findAll(Pageable pageable);
}
