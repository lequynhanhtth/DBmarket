package com.example.dbmarket.repository;

import com.example.dbmarket.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin,Integer> {
    @Query("select a from Admin a where a.email = ?1")
    public Optional<Admin> findByEmail(String email);
}
