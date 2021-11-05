package com.example.dbmarket.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Cart")

public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartId;
    @Column(name = "NumberOfProduct")
    private Integer numberOfProduct;
    @Column(name = "TotalPrice")
    private Double totalPrice;
    @OneToMany(mappedBy = "cart")
    private List<CartDetail> cartDetails;
    @ManyToOne
    @JoinColumn(name = "CustomerId")
    private Customer customer;



    public Cart(int cartId, Integer numberOfProduct, Double totalPrice, List<CartDetail> cartDetails, Customer customer) {
        this.cartId = cartId;
        this.numberOfProduct = numberOfProduct;
        this.totalPrice = totalPrice;
        this.cartDetails = cartDetails;
        this.customer = customer;
    }

    public Cart() {

    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public Integer getNumberOfProduct() {
        return numberOfProduct;
    }

    public void setNumberOfProduct(Integer numberOfProduct) {
        this.numberOfProduct = numberOfProduct;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<CartDetail> getCartDetails() {
        return cartDetails;
    }

    public void setCartDetails(List<CartDetail> cartDetails) {
        this.cartDetails = cartDetails;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
