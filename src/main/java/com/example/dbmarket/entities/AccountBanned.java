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
    @ManyToOne
    @JoinColumn(name = "Banned")
    private Banned banned;
    @ManyToOne
    @JoinColumn(name = "Customer")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "Supplier")
    private Supplier supplier;

    public int getAccountBannedId() {
        return accountBannedId;
    }

    public void setAccountBannedId(int accountBannedId) {
        this.accountBannedId = accountBannedId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Banned getBanned() {
        return banned;
    }

    public void setBanned(Banned banned) {
        this.banned = banned;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
