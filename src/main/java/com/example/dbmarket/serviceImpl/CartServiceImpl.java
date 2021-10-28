package com.example.dbmarket.serviceImpl;

import com.example.dbmarket.entities.Cart;
import com.example.dbmarket.repository.CartRepository;
import com.example.dbmarket.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CartServiceImpl implements CartService {
    @Autowired
    CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Cart getById(Integer id) {
        return cartRepository.getById(id);
    }

    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public void save(Cart cart) {
      cartRepository.save(cart);
    }

    @Override
    public Optional<Cart> findById(Integer id) {
        return cartRepository.findById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return cartRepository.existsById(id);
    }

    @Override
    public void deleteById(Integer id) {
        cartRepository.deleteById(id);
    }

    @Override
    public void delete(Cart entity) {
        cartRepository.delete(entity);
    }
}
