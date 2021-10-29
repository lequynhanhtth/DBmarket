package com.example.dbmarket.repository;
import com.example.dbmarket.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
@Query(value="SELECT TOP 10 with ties * FROM Product  ORDER BY date ",nativeQuery = true)
    List<Product> findTop10OrderByDate();
}
