package com.example.brand.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "products", schema = "t3h_2208", catalog = "")
@Data
public class ProductsEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic
    @Column(name = "alias")
    private String alias;

    @Basic
    @Column(name = "created_time")
    private Timestamp createdTime;

    @Basic
    @Column(name = "discount_percent")
    private Double discountPercent;

    @Basic
    @Column(name = "enabled")
    private boolean enabled;

    @Basic
    @Column(name = "full_description")
    private String fullDescription;

    @Basic
    @Column(name = "height")
    private double height;
    @Basic
    @Column(name = "in_stock")
    private Boolean inStock;
    @Basic
    @Column(name = "length")
    private double length;
    @Basic
    @Column(name = "main_image")
    private String mainImage;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "price")
    private double price;
    @Basic
    @Column(name = "short_description")
    private String shortDescription;
    @Basic
    @Column(name = "updated_time")
    private Timestamp updatedTime;
    @Basic
    @Column(name = "weight")
    private double weight;
    @Basic
    @Column(name = "width")
    private double width;
    @Basic
    @Column(name = "brand_id")
    private Integer brandId;
    @Basic
    @Column(name = "category_id")
    private Integer categoryId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductsEntity that = (ProductsEntity) o;
        return id == that.id && enabled == that.enabled && Double.compare(that.height, height) == 0 && Double.compare(that.length, length) == 0 && Double.compare(that.price, price) == 0 && Double.compare(that.weight, weight) == 0 && Double.compare(that.width, width) == 0 && Objects.equals(alias, that.alias) && Objects.equals(createdTime, that.createdTime) && Objects.equals(discountPercent, that.discountPercent) && Objects.equals(fullDescription, that.fullDescription) && Objects.equals(inStock, that.inStock) && Objects.equals(mainImage, that.mainImage) && Objects.equals(name, that.name) && Objects.equals(shortDescription, that.shortDescription) && Objects.equals(updatedTime, that.updatedTime) && Objects.equals(brandId, that.brandId) && Objects.equals(categoryId, that.categoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, alias, createdTime, discountPercent, enabled, fullDescription, height, inStock, length, mainImage, name, price, shortDescription, updatedTime, weight, width, brandId, categoryId);
    }
}
