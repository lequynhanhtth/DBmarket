package com.example.dbmarket.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Discount")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int discountId;
    @Column(name = "Discount")
    private Double discount;
    @Column(name = "Quantity")
    private Long quantity;
    @Column(name = "Condition")
    private Long condition;
    @Column(name = "DateStart")
    private LocalDate dateStart;
    @Column(name ="dateEnd")
    private LocalDate dateEnd;
    @OneToMany(mappedBy = "discount")
    private List<Order> orders;

    public int getDiscountId() {
        return discountId;
    }

    public void setDiscountId(int discountId) {
        this.discountId = discountId;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getCondition() {
        return condition;
    }

    public void setCondition(Long condition) {
        this.condition = condition;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
