package com.example.dbmarket.entities;

import javax.persistence.*;

@Entity
@Table(name = "Cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartId;
    @Column(name = "NumberOfProduct")
    private Integer numberOfProduct;
    @Column(name = "TotalPrice")
    private Double totalPrice;

}
