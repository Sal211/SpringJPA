package com.example.TestEntitywithSpring.Services;

import com.example.TestEntitywithSpring.DTO.CustomerCreateRequestDTO;
import com.example.TestEntitywithSpring.DTO.CustomerUpdateRequestDTO;
import com.example.TestEntitywithSpring.Entity.Customer;
import com.example.TestEntitywithSpring.ServiceResponder.ServiceResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface ICustomerService {
    ResponseEntity<ServiceResponse<Customer>> PostCustomer(CustomerCreateRequestDTO customer);


    ResponseEntity<ServiceResponse<List<Customer>>> GetCustomer();
    ResponseEntity<ServiceResponse<Optional<Customer>>> GetCustomerById(int id);
    ResponseEntity<ServiceResponse<Customer>> UpdateCustomer(CustomerUpdateRequestDTO customer);

    ResponseEntity<ServiceResponse<Customer>> DeleteCustomer(int id);
}
