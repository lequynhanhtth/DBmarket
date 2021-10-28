package com.example.dbmarket.service;

import com.example.dbmarket.entities.CartDetail;

import java.util.List;
import java.util.Optional;

public interface CartDetailService {
    List<CartDetail> findAll();

    void save(CartDetail cartDetail);

    void delete(int id);

    Optional<CartDetail> findById(int id);

    boolean existById(int id);
}
