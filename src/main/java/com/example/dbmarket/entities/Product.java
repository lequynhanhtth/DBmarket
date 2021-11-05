package com.example.dbmarket.entities;

import org.hibernate.mapping.Join;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    @Column(name = "ProductName")
    private String productName;
    @Column(name = "Description")
    private String description;
    @Column(name = "Price")
    private Long price;
    @Column(name = "Weight")
    private Double weight;
    @Column(name = "InStock")
    private Long inStock;
    @Column(name = "Discount")
    private Double discount;
    @Column(name = "Date")
    private LocalDate date;
    @OneToMany(mappedBy = "product")
    private List<Rate> rates;
    @ManyToOne
    @JoinColumn(name = "CategoryId")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "SupplierId")
    private Supplier supplier;
    @OneToMany(mappedBy = "product")
    private List<CartDetail> cartDetails;
    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails;
    @OneToMany(mappedBy = "product")
    private List<Photo> photos;

    public Product(int productId, String productName, String description, Long price, Double weight, Long inStock, Double discount, LocalDate date, List<Rate> rates, Category category, Supplier supplier, List<CartDetail> cartDetails, List<OrderDetail> orderDetails, List<Photo> photos) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.weight = weight;
        this.inStock = inStock;
        this.discount = discount;
        this.date = date;
        this.rates = rates;
        this.category = category;
        this.supplier = supplier;
        this.cartDetails = cartDetails;
        this.orderDetails = orderDetails;
        this.photos = photos;
    }

    public Product() {
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Long getInStock() {
        return inStock;
    }

    public void setInStock(Long inStock) {
        this.inStock = inStock;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public List<CartDetail> getCartDetails() {
        return cartDetails;
    }

    public void setCartDetails(List<CartDetail> cartDetails) {
        this.cartDetails = cartDetails;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
