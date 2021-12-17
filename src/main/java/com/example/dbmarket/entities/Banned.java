package com.example.dbmarket.entities;

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
    @OneToMany(mappedBy = "banned")
    private List<AccountBanned> accountBanneds;

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

    public List<AccountBanned> getAccountBanneds() {
        return accountBanneds;
    }

    public void setAccountBanneds(List<AccountBanned> accountBanneds) {
        this.accountBanneds = accountBanneds;
    }
}
