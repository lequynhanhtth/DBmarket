package com.example.dbmarket.serviceImpl;

import com.example.dbmarket.entities.Brand;
import com.example.dbmarket.repository.BrandRepository;
import com.example.dbmarket.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    BrandRepository brandRepository;
    @Override
    public void save(Brand brand) {
        brandRepository.save(brand);
    }

    @Override
    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    @Override
    public void deleteById(int brandId) {
        brandRepository.deleteById(brandId);
    }

    @Override
    public Optional<Brand> findById(int brandId) {
        return brandRepository.findById(brandId);
    }

    @Override
    public Page<Brand> findAll(Pageable pageable) {
        return brandRepository.findAll(pageable);
    }
}
