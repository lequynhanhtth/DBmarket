package com.example.dbmarket.entities;

import javax.persistence.*;

@Entity
@Table(name = "CartDetail")
public class CartDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartDetailId;
    @Column(name = "Quantity")
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "ProductId")
    public Product product;
    @ManyToOne
    @JoinColumn(name = "CartId")
    public Cart cart;

    public int getCartDetailId() {
        return cartDetailId;
    }

    public void setCartDetailId(int cartDetailId) {
        this.cartDetailId = cartDetailId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
