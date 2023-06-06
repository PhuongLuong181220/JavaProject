package com.example.brand.dto;


import lombok.Data;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
public class ProductDto {

    private Long id;
    private String alias;
    private Double discountPercent;
    private boolean enabled;
    private String fullDescription;
    private double height;
    private Boolean inStock;
    private double length;
    private String mainImage;
    private String name;
    private double price;
    private String shortDescription;
    private Timestamp updatedTime;
    private double weight;
    private double width;
    private Integer brandId;
    private Integer categoryId;
    private MultipartFile fimeImage;

}
