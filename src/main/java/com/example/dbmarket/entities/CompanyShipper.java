package com.example.dbmarket.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "CompanyShipper")
public class CompanyShipper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int companyId;
    @Column(name = "companyName")
    private String companyName;
    @Column(name = "fee")
    private Long fee;
    @OneToMany(mappedBy = "companyShipper")
    private List<Shipper> shippers;


}
