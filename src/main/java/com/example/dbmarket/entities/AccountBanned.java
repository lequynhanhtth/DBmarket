package com.example.dbmarket.entities;

import javax.persistence.*;

@Entity
@Table(name = "AccountBanned")
public class AccountBanned {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountBannedId;
    @Column(name = "Description")
    private String description;
    @ManyToOne()
}
