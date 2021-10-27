package com.example.dbmarket.entities;

import javax.persistence.*;

@Entity
@Table(name = "CartDetail")
public class CartDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartDetailId;
}
