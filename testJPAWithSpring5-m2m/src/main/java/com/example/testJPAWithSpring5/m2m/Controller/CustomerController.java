package com.example.testJPAWithSpring5.m2m.Controller;

import com.example.testJPAWithSpring5.m2m.DTO.CreateRequestCustomerDTO;
import com.example.testJPAWithSpring5.m2m.DTO.UpdateRequestCustomerDTO;
import com.example.testJPAWithSpring5.m2m.Services.Imp.CustomerServiceImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Customer")
public class CustomerController {
    @Autowired
    private CustomerServiceImp customerServiceImp;

    @GetMapping("/GetCustomer")
    public ResponseEntity<?> GetAllCustomer(){
        return customerServiceImp.FindAllCustomers();
    }
    @PostMapping("/PostCustomer")
    public ResponseEntity<?> PostCustomer(@Valid @RequestBody CreateRequestCustomerDTO customer){
        return customerServiceImp.PostCustomer(customer);
    }
    @PostMapping("/UpdateCustomer")
    public ResponseEntity<?> UpdateCustomer(@Valid @RequestBody UpdateRequestCustomerDTO customer){
        return customerServiceImp.UpdateCustomer(customer);
    }
    @GetMapping("/GetCustomerByName")
    public ResponseEntity<?> GetCustomerByName( @RequestBody String name){
        return customerServiceImp.FindCustomerByName(name);
    }
    @PostMapping("/DeleteCustomer/{id}")
    public ResponseEntity<?> DeleteCustomer(@PathVariable int id){
        return customerServiceImp.DeleteCustomer(id);
    }
}
