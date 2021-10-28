package com.example.dbmarket.repository;

import com.example.dbmarket.entities.Category;
import com.example.dbmarket.entities.Order;
import com.example.dbmarket.entities.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,Integer> {
}
