package com.example.dbmarket.repository;

import com.example.dbmarket.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart , Integer> {

}
