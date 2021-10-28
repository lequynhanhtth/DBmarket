package com.example.dbmarket.repository;


import com.example.dbmarket.entities.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetail , Integer> {

}
