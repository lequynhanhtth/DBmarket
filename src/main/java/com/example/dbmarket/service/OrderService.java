package com.example.dbmarket.service;

import com.example.dbmarket.entities.Order;
import com.example.dbmarket.entities.OrderDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> findAll();

    void save(Order order);

    void delete(int id);

    Optional<Order> findById(int id);

    boolean existById(int id);

    List<Order> findOrderBySupplierId(int id);

    Page<Order> findAll(Pageable pageable);
}
