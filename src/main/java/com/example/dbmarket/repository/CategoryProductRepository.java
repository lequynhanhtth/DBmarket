package com.example.dbmarket.repository;

import com.example.dbmarket.entities.CategoryProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryProductRepository extends JpaRepository<CategoryProduct,Integer> {
}
