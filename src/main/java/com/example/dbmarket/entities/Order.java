package com.example.dbmarket.entities;

import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    @Column(name = "Weight")
    private double weight;
    @Column(name = "ShipCost")
    private long shipCost;
    @Column(name = "Phone")
    private String phone;
    @Column(name = "Date")
    private LocalDate date;
    @Column(name = "RequiredDate")
    private LocalDate requiredDate;
    @Column(name = "ShippedDate")
    private LocalDate shippedDate;
    @Column(name = "TimeOrder")
    private LocalTime timeOrder;
    @Column(name = "TimeShipped")
    private LocalTime timeShipped;
    @Column(name = "TimeRequired")
    private LocalTime timeRequired;
    @ManyToOne
    @JoinColumn(name = "DiscountId")
    private Discount discount;
    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;
    @ManyToOne
    @JoinColumn(name = "ShipperId")
    private Shipper shipper;
    @ManyToOne
    @JoinColumn(name = "BillInfoId")
    private BillInfo billInfo;
}
