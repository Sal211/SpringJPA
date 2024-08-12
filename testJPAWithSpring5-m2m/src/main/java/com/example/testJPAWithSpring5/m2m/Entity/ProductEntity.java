package com.example.testJPAWithSpring5.m2m.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "tblProducts")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "TXN_ID")
    Long id;

    @Column(name = "TXN_PRODUCTNAME")
    String productName;

    @Column(name = "TXN_CATEGORY")
    String category;

    @JsonIgnore
    @ManyToMany(mappedBy = "products" , cascade = CascadeType.ALL)
    Set<CustomerEntity> customers = new HashSet<>();
}
