package com.example.dbmarket.repository;

import com.example.dbmarket.entities.Rate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RateRepository extends JpaRepository<Rate, Integer> {
    @Query("SELECT r FROM Rate r WHERE r.product.productId = :productId")
    Page<Rate> findRateByProductId(int productId, Pageable pageable);
}
