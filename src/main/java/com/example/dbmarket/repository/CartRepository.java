package com.example.dbmarket.repository;

import com.example.dbmarket.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart , Integer> {
@Query("SELECT sum(cd.quantity*cd.product.price) FROM Cart c , CartDetail cd WHERE cd.cart.cartId = ?1")
    public Double getTotalCart(int cartID);
}
