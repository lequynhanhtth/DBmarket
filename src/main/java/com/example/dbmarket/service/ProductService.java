package com.example.dbmarket.service;

import com.example.dbmarket.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();

    void save(Product product);

    void delete(int id);

    Optional<Product> findById(int id);

    boolean existById(int id);

    List<Product> findBySupplierId(int id);

    List<Product> findTop10OrderByDate();

    Page<Product> findByCategoryOrderByRate(int keyword, Pageable pageable);

    Page<Product> findByCategoryId(int id, Pageable pageable);

    Page<Product> findManyOption(List<Integer> brands, List<Integer> categoryProducts, long minPrice, long maxPrice, int categoryId, Pageable pageable, String productName);

    Page<Product> findAll(Pageable pageable);

    Page<Product> findProductNotAccept(Pageable pageable);

    void changeStatusFalseProductBySupplier(int supplierId);

    void changeStatusTrueProductBySupplier(int supplierId);
}
