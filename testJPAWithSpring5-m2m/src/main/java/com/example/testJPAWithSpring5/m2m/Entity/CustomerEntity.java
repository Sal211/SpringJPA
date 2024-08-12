package com.example.testJPAWithSpring5.m2m.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "tblCustomers")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "TXN_ID")
    int id;
    @Column(name = "TXN_NAME")
    String name;
    @Column(name = "TXN_SEX")
    String sex;

    @ManyToMany
    @JoinTable(
            name = "customer_Product",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    Set<ProductEntity> products = new HashSet<>();
}
