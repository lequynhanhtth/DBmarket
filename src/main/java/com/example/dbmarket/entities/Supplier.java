package com.example.dbmarket.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Supplier")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String supplierId;
    @Column(name = "Username")
    private String username;
    @Column(name = "Password")
    private String password;
    @Column(name = "Fullname")
    private String fullname;
    @Column(name = "Phone")
    private String phone;
    @Column(name = "Email")
    private String email;
    @Column(name = "Address")
    private String address;
    @OneToMany(mappedBy = "supplier")
    private List<Product> products;

}
