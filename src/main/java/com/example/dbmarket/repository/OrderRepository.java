package com.example.dbmarket.repository;

import com.example.dbmarket.entities.Category;
import com.example.dbmarket.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository  extends JpaRepository<Order,Integer> {

}
