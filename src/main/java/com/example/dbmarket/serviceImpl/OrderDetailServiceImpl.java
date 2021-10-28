package com.example.dbmarket.serviceImpl;

import com.example.dbmarket.entities.OrderDetail;
import com.example.dbmarket.repository.OrderDetailRepository;
import com.example.dbmarket.repository.OrderRepository;
import com.example.dbmarket.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    OrderDetailRepository
            orderDetailRepository;

    @Override
    public List<OrderDetail> findAll() {
        return orderDetailRepository.findAll();
    }

    @Override
    public void save(OrderDetail orderDetail) {
        orderDetailRepository.save(orderDetail);
    }

    @Override
    public void delete(int id) {
        orderDetailRepository.deleteById(id);
    }

    @Override
    public Optional<OrderDetail> findById(int id) {
        return orderDetailRepository.findById(id);
    }

    @Override
    public boolean existById(int id) {
        return orderDetailRepository.existsById(id);
    }
}
