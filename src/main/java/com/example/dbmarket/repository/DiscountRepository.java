package com.example.dbmarket.repository;

import com.example.dbmarket.entities.CompanyShipper;
import com.example.dbmarket.entities.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<Discount,Integer> {
}
