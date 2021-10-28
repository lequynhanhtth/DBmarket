package com.example.dbmarket.serviceImpl;

import com.example.dbmarket.entities.Discount;
import com.example.dbmarket.repository.DiscountRepository;
import com.example.dbmarket.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DiscountServiceImpl implements DiscountService {
    @Autowired
    DiscountRepository discountRepository;

    @Override
    public List<Discount> findAll() {
        return discountRepository.findAll();
    }

    @Override
    public void save(Discount discount) {
        discountRepository.save(discount);
    }

    @Override
    public void delete(int id) {
        discountRepository.deleteById(id);
    }

    @Override
    public Optional<Discount> findById(int id) {
        return discountRepository.findById(id);
    }

    @Override
    public boolean existById(int id) {
        return discountRepository.existsById(id);
    }
}
