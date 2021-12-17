package com.example.dbmarket.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "brand")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int brandId;
    @Column(name = "brandName")
    private String brandName;
    @ManyToOne
    @JoinColumn(name = "CategoryId")
    private Category category;
    @OneToMany(mappedBy = "brand")
    private List<Product> products;

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
