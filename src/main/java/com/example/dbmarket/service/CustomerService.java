package com.example.dbmarket.service;

import com.example.dbmarket.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


public interface CustomerService {
    public List<Customer> findAll();

    public void save (Customer customer);

    public void delete(int id);

    public Optional<Customer> findById(int id);

    public boolean existById(int id);

    public Optional<Customer> findByEmail(String email);

    Page<Customer> findAll(Pageable pageable);
}
