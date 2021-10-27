package com.example.dbmarket.entities;


import javax.persistence.*;

@Entity
@Table(name = "OrderDetail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderDetailId;
    @Column(name = "Quantity")
    private Integer quantity;
    @Column(name = "TotalPrice")
    private Long totalPrice;
    @ManyToOne
    @JoinColumn(name ="OrderId")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "ProductId")
    private Product product;
}
