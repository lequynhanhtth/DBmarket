package com.example.dbmarket.repository;


import com.example.dbmarket.entities.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetail, Integer> {
    @Query("select o from CartDetail o where o.product.productId = ?1 and o.cart.cartId = ?2")
    public Optional<CartDetail> findByProductId(int productId , int cartId);
}
