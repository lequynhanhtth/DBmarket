package com.example.dbmarket.repository;

import com.example.dbmarket.entities.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PhotoRepository extends JpaRepository<Photo,Integer> {
    @Query("SELECT o from Photo o where o.product.productId = ?1")
    public List<Photo> findByProductid(int id);
}
