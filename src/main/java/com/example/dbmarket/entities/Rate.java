package com.example.dbmarket.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Rate")
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rateId;
    @Column(name = "Star")
    private Integer star;
    @Column(name = "Date")
    private LocalDate date;
    @Column(name = "Comment")
    private String comment;
    @ManyToOne
    @JoinColumn(name = "ProductId")
    private Product product;

}
