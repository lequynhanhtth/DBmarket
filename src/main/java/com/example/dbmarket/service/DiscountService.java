package com.example.dbmarket.service;

import com.example.dbmarket.entities.Discount;
import com.example.dbmarket.entities.OrderDetail;

import java.util.List;
import java.util.Optional;

public interface DiscountService {
    public List<Discount> findAll();

    public void save (Discount discount);

    public void delete(int id);

    public Optional<Discount> findById(int id);

    public boolean existById(int id);
}
