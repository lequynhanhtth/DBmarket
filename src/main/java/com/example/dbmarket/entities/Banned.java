package com.example.dbmarket.entities;

import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "banned")
public class Banned {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bannedId;
    @Column(name = "Reason")
    private String reason;
    @Column(name ="Date")
    private LocalDate date;
    @OneToMany(mappedBy = "banned")
    private List<Customer> customers;

    public int getBannedId() {
        return bannedId;
    }

    public void setBannedId(int bannedId) {
        this.bannedId = bannedId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
