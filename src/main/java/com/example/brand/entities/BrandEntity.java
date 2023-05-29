package com.example.brand.entities;


import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "brand", schema = "db_2206", catalog = "")
@Data
public class BrandEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    @Column(name = "NAME")
    private String name;
    @Basic
    @Column(name = "DESCRIPTION",length = 1000)
    private String description;

//    @OneToMany(fetch = FetchType.EAGER)
//    @JoinColumn(name = "BRAND_ID", referencedColumnName = "ID", insertable = false, updatable = false)
//    List<ProductEntity> productEntities;

}
