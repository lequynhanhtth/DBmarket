package com.example.dbmarket.service;

import com.example.dbmarket.entities.Rate;

import java.util.List;
import java.util.Optional;

public interface RateService {
    public List<Rate> findAll();

    public void save (Rate rate);

    public void delete(int id);

    public Optional<Rate> findById(int id);

    public boolean existById(int id);
}
