package com.example.dbmarket.serviceImpl;

import com.example.dbmarket.entities.Product;
import com.example.dbmarket.entities.Rate;
import com.example.dbmarket.repository.ProductRepository;
import com.example.dbmarket.repository.RateRepository;
import com.example.dbmarket.service.ProductService;
import com.example.dbmarket.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RateServiceImpl implements RateService {
    @Autowired
    RateRepository rateRepository;

    @Override
    public List<Rate> findAll() {
        return rateRepository.findAll();
    }

    @Override
    public void save(Rate rate) {
        rateRepository.save(rate);
    }

    @Override
    public void delete(int id) {
        rateRepository.deleteById(id);
    }

    @Override
    public Optional<Rate> findById(int id) {
        return rateRepository.findById(id);
    }

    @Override
    public boolean existById(int id) {
        return rateRepository.existsById(id);
    }
}
