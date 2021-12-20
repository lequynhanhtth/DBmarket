package com.example.dbmarket.serviceImpl;

import com.example.dbmarket.entities.Customer;
import com.example.dbmarket.entities.Product;
import com.example.dbmarket.repository.CustomerRepository;
import com.example.dbmarket.repository.ProductRepository;
import com.example.dbmarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public Optional<Product> findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public boolean existById(int id) {
        return productRepository.existsById(id);
    }

    @Override
    public List<Product> findBySupplierId(int id) {
        return productRepository.findBySupplierId(id);
    }

    @Override
    public List<Product> findTop10OrderByDate() {
        return productRepository.findTop10OrderByDate();
    }

    @Override
    public Page<Product> findByCategoryOrderByRate(int keyword, Pageable pageable) {
        return productRepository.findByCategoryOrderByRate(keyword, pageable);
    }

    @Override
    public Page<Product> findByCategoryId(int id, Pageable pageable) {
        return productRepository.findByCategoryId(id, pageable);
    }

    @Override
    public Page<Product> findManyOption(List<Integer> brands, List<Integer> categoryProducts, long minPrice, long maxPrice, int categoryId, Pageable pageable, String productName) {
        return productRepository.findManyOption(brands, categoryProducts, minPrice, maxPrice, categoryId, pageable, productName);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Page<Product> findProductNotAccept(Pageable pageable) {
        return productRepository.findProductNotAccept(pageable);
    }

    @Override
    public void changeStatusFalseProductBySupplier(int supplierId) {
        productRepository.changeStatusFalseProductBySupplier(supplierId);
    }

    @Override
    public void changeStatusTrueProductBySupplier(int supplierId) {
        productRepository.changeStatusTrueProductBySupplier(supplierId);
    }

    @Override
    public void changeStatusTrueProductByCategoryId(int categoryId) {
        productRepository.changeStatusTrueProductByCategoryId(categoryId);
    }

    @Override
    public void changeStatusFalseProductByCategoryId(int categoryId) {
        productRepository.changeStatusFalseProductByCategoryId(categoryId);
    }
}
