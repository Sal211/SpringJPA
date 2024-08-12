package com.example.testJPAWithSpring5.m2m.Repository;

import com.example.testJPAWithSpring5.m2m.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity,Integer> {
}
