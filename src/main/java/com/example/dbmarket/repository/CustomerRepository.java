package com.example.dbmarket.repository;

import com.example.dbmarket.entities.Customer;
import com.example.dbmarket.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    @Query(value="SELECT c FROM Customer c WHERE c.email = ?1")
    public Optional<Customer> findByEmail(String email);
}
