package com.example.dbmarket.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Discount")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int discountId;
    @Column(name = "CodeName")
    private String codeName;
    @Column(name = "Discount")
    private Double discount;
    @Column(name = "Quantity")
    private Long quantity;
    @Column(name = "Condition")
    private Long condition;
    @OneToMany(mappedBy = "discount")
    private List<Order> orders;
}
