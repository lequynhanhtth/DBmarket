package com.example.dbmarket.repository;

import com.example.dbmarket.entities.Category;
import com.example.dbmarket.entities.CompanyShipper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyShipperRepository extends JpaRepository<CompanyShipper,Integer> {
}
