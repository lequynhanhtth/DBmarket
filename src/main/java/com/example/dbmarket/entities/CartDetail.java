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
}
