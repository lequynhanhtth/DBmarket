package com.example.dbmarket.repository;

import com.example.dbmarket.entities.Category;
import com.example.dbmarket.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderRepository  extends JpaRepository<Order,Integer> {
    @Query("SELECT o FROM Order o WHERE o.supplier.supplierId = ?1")
    public List<Order> findOrderBySupplierId(int id);
}
