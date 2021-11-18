package com.example.dbmarket.repository;

import com.example.dbmarket.entities.Customer;
import com.example.dbmarket.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SupplierRepository extends JpaRepository<Supplier,Integer> {
    @Query(value="SELECT c FROM Supplier c WHERE c.email = ?1")
    public Optional<Supplier> findByEmail(String email);
}
