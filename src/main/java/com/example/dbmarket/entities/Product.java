package com.example.dbmarket.entities;

import org.hibernate.mapping.Join;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    @Column(name = "ProductName")
    private String productName;
    @Column(name = "Description")
    private String description;
    @Column(name = "Price")
    private Long price;
    @Column(name = "Weight")
    private Double weight;
    @Column(name = "InStock")
    private Long inStock;
    @Column(name = "Discount")
    private Double discount;
    @OneToMany(mappedBy = "product")
    private List<Rate> rates;
    @ManyToOne
    @JoinColumn(name = "CategoryId")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "SupplierId")
    private Supplier supplier;
    @OneToMany(mappedBy = "product")
    private List<CartDetail> cartDetails;
    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails;
}
