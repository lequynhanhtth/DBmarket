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
    private double shipCost;
    @Column(name = "Phone")
    private String phone;
    @Column(name = "Date")
    private LocalDate date;
    @Column(name = "Address")
    private String address;
    @Column(name ="Fullname")
    private String fullname;
    @Column(name = "Status")
    private String status;
    @Column(name = "RequiredDate")
    private LocalDate requiredDate;
    @Column(name = "Email")
    private String email;
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
    @ManyToOne
    @JoinColumn(name = "Supplier")
    private Supplier supplier;
    @ManyToOne
    @JoinColumn(name = "Customer")
    private Customer customer;
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getShipCost() {
        return shipCost;
    }

    public void setShipCost(double shipCost) {
        this.shipCost = shipCost;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(LocalDate requiredDate) {
        this.requiredDate = requiredDate;
    }

    public LocalDate getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(LocalDate shippedDate) {
        this.shippedDate = shippedDate;
    }

    public LocalTime getTimeOrder() {
        return timeOrder;
    }

    public void setTimeOrder(LocalTime timeOrder) {
        this.timeOrder = timeOrder;
    }

    public LocalTime getTimeShipped() {
        return timeShipped;
    }

    public void setTimeShipped(LocalTime timeShipped) {
        this.timeShipped = timeShipped;
    }

    public LocalTime getTimeRequired() {
        return timeRequired;
    }

    public void setTimeRequired(LocalTime timeRequired) {
        this.timeRequired = timeRequired;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Shipper getShipper() {
        return shipper;
    }

    public void setShipper(Shipper shipper) {
        this.shipper = shipper;
    }

    public BillInfo getBillInfo() {
        return billInfo;
    }

    public void setBillInfo(BillInfo billInfo) {
        this.billInfo = billInfo;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {

        this.supplier = supplier;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
