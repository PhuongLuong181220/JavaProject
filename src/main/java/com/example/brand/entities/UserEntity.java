package com.example.brand.entities;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "t3h_2208", catalog = "")
@Data
public class UserEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    @Column(name = "USER_NAME")
    private String userName;
    @Basic
    @Column(name = "PASSWORD")
    private String password;
    @Basic
    @Column(name = "FULL_NAME")
    private String fullName;
    @Basic
    @Column(name = "ADDRESS")
    private String address;
    @Basic
    @Column(name = "STATUS")
    private Integer status;
    @Basic
    @Column(name = "ROLE")
    private String role;
}
