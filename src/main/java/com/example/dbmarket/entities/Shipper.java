package com.example.dbmarket.entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Shipper")
public class Shipper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int shipperId;
    @Column(name = "Phone")
    private String phone;
    @Column(name = "Fullname")
    private String fullname;
    @ManyToOne
    @JoinColumn(name = "CompanyId")
    private CompanyShipper companyShipper;
    @OneToMany(mappedBy = "shipper")
    private List<Order> orders;
}
