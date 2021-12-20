package com.example.dbmarket.service;

import com.example.dbmarket.entities.Rate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface RateService {
    List<Rate> findAll();

    void save(Rate rate);

    void delete(int id);

    Optional<Rate> findById(int id);

    boolean existById(int id);

    Page<Rate> findAll(Pageable pageable);

    Page<Rate> findRateByProductId(int productId,Pageable pageable);
}
