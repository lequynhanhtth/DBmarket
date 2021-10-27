package com.example.dbmarket.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "BillInfo")
public class BillInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int billInfoId;
    @Column(name = "CreditCardNo")
    private String creditCardNo;
    @Column(name = "Date")
    private LocalDate date;
    @Column(name = "CreditCardPin")
    private String creditCardPin;
    @OneToMany(mappedBy = "billInfo")
    private List<Order> orders;
    @ManyToOne
    @JoinColumn(name = "CustomerId")
    private Customer customer;
}
