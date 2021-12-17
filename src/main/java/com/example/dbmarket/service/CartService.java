package com.example.dbmarket.service;

import com.example.dbmarket.entities.Cart;
import com.example.dbmarket.entities.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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

    Double getTotalPrice(int cartID);

}
