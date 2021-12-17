package com.example.dbmarket.service;

import com.example.dbmarket.entities.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface SupplierService {
    List<Supplier> findAll();

    void save (Supplier supplier);

    void delete(int id);

    Optional<Supplier> findById(int id);

    boolean existById(int id);
    Optional<Supplier> findByEmail(String email);

    Page<Supplier> findAll(Pageable pageable);
}
