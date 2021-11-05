package com.example.dbmarket.serviceImpl;

import com.example.dbmarket.entities.CartDetail;
import com.example.dbmarket.repository.CartDetailRepository;
import com.example.dbmarket.service.CartDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CartDetailServiceImpl implements CartDetailService {
    @Autowired
    CartDetailRepository cartDetailRepository;
    @Override
    public List<CartDetail> findAll() {
        return cartDetailRepository.findAll();
    }

    @Override
    public void save(CartDetail cartDetail) {
        cartDetailRepository.save(cartDetail);
    }

    @Override
    public void delete(int id) {
        cartDetailRepository.deleteById(id);
    }

    @Override
    public Optional<CartDetail> findById(int id) {
        return cartDetailRepository.findById(id);
    }

    @Override
    public boolean existById(int id) {
        return cartDetailRepository.existsById(id);
    }

    @Override
    public Optional<CartDetail> findByProductId(int productId, int cartId) {
        return cartDetailRepository.findByProductId(productId,cartId);
    }
}
