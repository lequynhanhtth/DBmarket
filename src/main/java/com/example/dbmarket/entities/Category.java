package com.example.dbmarket.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Category")
public class Category {
    @Id
    private String categoryId;
    @Column(name = "Name")
    private String name;
    @Column(name = "Description")
    private String description;
    @Column(name = "Photo")
    private String photo;
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
