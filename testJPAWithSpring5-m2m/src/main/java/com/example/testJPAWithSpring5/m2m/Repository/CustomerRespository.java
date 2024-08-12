package com.example.testJPAWithSpring5.m2m.Repository;

import com.example.testJPAWithSpring5.m2m.Entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

public interface CustomerRespository extends JpaRepository<CustomerEntity,Integer> {
    CustomerEntity findByName(String name);
    boolean existsByName(String name);
}
