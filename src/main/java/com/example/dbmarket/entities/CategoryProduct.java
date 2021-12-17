package com.example.dbmarket.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CategoryProduct")
public class CategoryProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryProductId;
    @Column(name = "CategoryProductName")
    private String categoryProductName;
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;
    @OneToMany(mappedBy = "categoryProduct")
    private List<Product> products;
    public int getCategoryProductId() {
        return categoryProductId;
    }

    public void setCategoryProductId(int categoryProductId) {
        this.categoryProductId = categoryProductId;
    }

    public String getCategoryProductName() {
        return categoryProductName;
    }

    public void setCategoryProductName(String categoryProductName) {
        this.categoryProductName = categoryProductName;
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
