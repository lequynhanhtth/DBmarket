package com.example.dbmarket.service;

import com.example.dbmarket.entities.Cart;

import java.util.List;
import java.util.Optional;

public interface CartService {
    Cart getById(Integer id);

    List<Cart> findAll();

    void save(Cart cart);

    Optional<Cart> findById(Integer id);

    boolean existsById(Integer id);

    void deleteById(Integer id);

    void delete(Cart entity);
}
