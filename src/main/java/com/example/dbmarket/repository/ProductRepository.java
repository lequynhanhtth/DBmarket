package com.example.dbmarket.repository;
import com.example.dbmarket.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
@Query(value="SELECT TOP 10 with ties * FROM Product  ORDER BY date ",nativeQuery = true)
    List<Product> findTop10OrderByDate();
@Query("select o from Product o where o.category.categoryId like ?1")
    Page<Product> findByCategoryOrderByRate(String keyword, Pageable pageable);
@Query("SELECT  o FROM Product  o WHERE o.supplier.supplierId = ?1")
    List<Product> findBySupplierId(int Id);
}
