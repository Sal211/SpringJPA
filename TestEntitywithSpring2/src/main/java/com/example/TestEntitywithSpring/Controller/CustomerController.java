package com.example.TestEntitywithSpring.Controller;

import com.example.TestEntitywithSpring.DTO.CustomerCreateRequestDTO;
import com.example.TestEntitywithSpring.DTO.CustomerUpdateRequestDTO;
import com.example.TestEntitywithSpring.Entity.Customer;
import com.example.TestEntitywithSpring.ServiceResponder.ServiceResponse;
import com.example.TestEntitywithSpring.Services.CustomerService;
import com.example.TestEntitywithSpring.Services.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping( "/Customers")
public class CustomerController {
    private  ICustomerService customerService;
    public CustomerController(ICustomerService customerService) { this.customerService = customerService; }
    @PostMapping("/PostCustomer")
    public ResponseEntity<ServiceResponse<Customer>> PostCustomer(@RequestBody CustomerCreateRequestDTO customer) {
        return customerService.PostCustomer(customer);
    }
    @GetMapping("/GetCustomer")
    public ResponseEntity<ServiceResponse<List<Customer>>> GetCustomer() {
        return customerService.GetCustomer();
    }
    @PostMapping("/DeleteCustomer/{id}")
    public ResponseEntity<ServiceResponse<Customer>> DeleteCustomer(@PathVariable int id) {
        return customerService.DeleteCustomer(id);
    }
    @PostMapping("/UpdateCustomer")
    public ResponseEntity<ServiceResponse<Customer>> UpdateCustomer(@RequestBody CustomerUpdateRequestDTO customer) {
        return customerService.UpdateCustomer(customer);
    }
    @GetMapping("/GetCustomerById/{Id}")
    public ResponseEntity<ServiceResponse<Optional<Customer>>> GetCustomerById(@PathVariable int Id) {
        return  customerService.GetCustomerById(Id);
    }
}
