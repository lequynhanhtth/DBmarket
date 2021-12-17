package com.example.dbmarket.service;

import com.example.dbmarket.entities.Admin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface AdminService {
    public void save(Admin admin);

    public void deleteById(int id);

    public List<Admin> findAll();

    public Optional<Admin> findById(int id);

    public Optional<Admin> findByAdmin(String email);

    public Page<Admin> findAll(Pageable pageable);
}
