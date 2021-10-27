package com.example.dbmarket.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    @Column(name="Username")
    private String username;
    @Column(name = "Password")
    private String password;
    @Column(name = "Fullname")
    private String fullname;
    @Column(name ="Phone")
    private String phone;
    @Column(name = "Email")
    private String email;
    @OneToMany(mappedBy = "customer")
    private List<Cart> cart;
    @OneToMany(mappedBy = "customer")
    private List<BillInfo> billInfos;
}
