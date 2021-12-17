package com.example.dbmarket.service;

import com.example.dbmarket.entities.Supplier;

import java.util.List;
import java.util.Optional;

public interface SupplierService {
    public List<Supplier> findAll();

    public void save (Supplier supplier);

    public void delete(int id);

    public Optional<Supplier> findById(int id);

    public boolean existById(int id);
    public Optional<Supplier> findByEmail(String email);
}
