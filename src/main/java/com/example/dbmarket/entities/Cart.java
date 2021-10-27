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
}
