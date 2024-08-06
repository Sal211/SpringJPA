package com.example.TestEntitywithSpring.Repository;

import com.example.TestEntitywithSpring.Entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
