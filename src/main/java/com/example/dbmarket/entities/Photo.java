package com.example.dbmarket.entities;

import javax.persistence.*;

@Entity
@Table(name="Photo")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int photoId;
    @Column(name = "photoName")
    private String photoName;
    @ManyToOne
    @JoinColumn(name = "ProductId")
    private Product product;

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

