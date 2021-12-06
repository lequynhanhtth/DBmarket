package com.example.dbmarket.repository;

import com.example.dbmarket.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category , String> {

}
