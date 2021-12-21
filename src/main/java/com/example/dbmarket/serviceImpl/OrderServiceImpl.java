package com.example.dbmarket.serviceImpl;

import com.example.dbmarket.entities.Order;
import com.example.dbmarket.repository.OrderRepository;
import com.example.dbmarket.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void delete(int id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Optional<Order> findById(int id) {
        return orderRepository.findById(id);
    }

    @Override
    public boolean existById(int id) {
        return orderRepository.existsById(id);

    }

    @Override
    public List<Order> findOrderBySupplierId(int id) {
        return orderRepository.findOrderBySupplierId(id);
    }

    @Override
    public Page<Order> findAll(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    @Override
    public Double getNumberOrderDoneBySupplierId(int supplierId) {
        return orderRepository.getNumberOrderDoneBySupplierId(supplierId);
    }
}
