package com.example.dbmarket.service;

import com.example.dbmarket.entities.OrderDetail;

import java.util.List;
import java.util.Optional;

public interface OrderDetailService {
    public List<OrderDetail> findAll();

    public void save(OrderDetail orderDetail);

    public void delete(int id);

    public Optional<OrderDetail> findById(int id);

    public boolean existById(int id);

    Double getNumberProductBySupplierId(int supplierId);

    Double getTotalPriceBySupplierId(int supplierId);

}
