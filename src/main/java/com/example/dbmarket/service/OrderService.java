package com.example.dbmarket.service;

import com.example.dbmarket.entities.Order;
import com.example.dbmarket.entities.OrderDetail;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    public List<Order> findAll();

    public void save (Order order);

    public void delete(int id);

    public Optional<Order> findById(int id);

    public boolean existById(int id);
}
