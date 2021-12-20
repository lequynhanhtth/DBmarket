package com.example.dbmarket.repository;

import com.example.dbmarket.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "SELECT TOP 10 with ties * FROM Product  ORDER BY date  WHERE Accept = true AND status = true", nativeQuery = true)
    List<Product> findTop10OrderByDate();

    @Query("select o from Product o where o.category.categoryId like ?1 and o.accept = false and o.status = false")
    Page<Product> findByCategoryOrderByRate(int keyword, Pageable pageable);

    @Query("SELECT  o FROM Product  o WHERE o.supplier.supplierId = ?1")
    List<Product> findBySupplierId(int Id);

    @Query("Select o FROM Product o WHERE o.category.categoryId =  ?1 and o.status = true and o.accept = true")
    Page<Product> findByCategoryId(int id, Pageable pageable);

    @Query("SELECT o FROM Product o WHERE o.brand.brandId in (:brands) and o.categoryProduct.categoryProductId in (:categoryProducts) and o.price > :minPrice and o.price < :maxPrice and o.category.categoryId = :categoryId and o.productName = :productName and o.status = true and o.accept = true")
    Page<Product> findManyOption(List<Integer> brands, List<Integer> categoryProducts, long minPrice, long maxPrice, int categoryId, Pageable pageable, String productName);

    @Query("SELECT o FROM Product o WHERE o.accept = false")
    Page<Product> findProductNotAccept(Pageable pageable);

    @Modifying
    @Query("UPDATE Product p SET p.status='false' WHERE p.supplier.supplierId = :supplier")
    void changeStatusFalseProductBySupplier(int supplier);

    @Modifying
    @Query("UPDATE Product p SET p.status='true' WHERE p.supplier.supplierId = :supplier")
    void changeStatusTrueProductBySupplier(int supplier);

    @Modifying
    @Query("UPDATE Product p SET p.status='true' WHERE p.category.categoryId = :categoryId")
    void changeStatusTrueProductByCategoryId(int categoryId);

    @Modifying
    @Query("UPDATE Product p SET p.status='false' WHERE p.category.categoryId = :categoryId")
    void changeStatusFalseProductByCategoryId(int categoryId);
}
