package com.example.TestEntitywithSpring.Services;

import com.example.TestEntitywithSpring.DTO.CustomerCreateRequestDTO;
import com.example.TestEntitywithSpring.DTO.CustomerUpdateRequestDTO;
import com.example.TestEntitywithSpring.Entity.Customer;
import com.example.TestEntitywithSpring.Repository.CustomerRepository;
import com.example.TestEntitywithSpring.ServiceResponder.ServiceResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class CustomerService implements ICustomerService {
    @Autowired
    private    CustomerRepository customerRepository;
    private <T> ResponseEntity<ServiceResponse<T>> HandleError(String Msg,Exception ex ){
        return ResponseEntity.internalServerError().body(new ServiceResponse<>("Error "+Msg+" customer", null, ex.getMessage(), false));
    }
    @Override
    public ResponseEntity<ServiceResponse<Customer>> PostCustomer(CustomerCreateRequestDTO customer) {
        try {
            Customer _newCustomer = new Customer();
            _newCustomer.setName(customer.getName());
            _newCustomer.setAddress(customer.getAddress());
            _newCustomer.setInactive(true);
            customerRepository.save(_newCustomer);
            return ResponseEntity.ok(new ServiceResponse<>("Customer saved successfully", _newCustomer, null, true));
        } catch (Exception ex) {
            return HandleError("Adding", ex);
        }
    }

    @Override
    public ResponseEntity<ServiceResponse<List<Customer>>> GetCustomer() {
        try{
            List<Customer> customers = (List<Customer>) customerRepository.findAll();
            return ResponseEntity.ok(new ServiceResponse<>("Customer List", customers, null, true));
        } catch (Exception e){
            return HandleError("Getting", e);
        }
    }

    @Override
    public ResponseEntity<ServiceResponse<Optional<Customer>>> GetCustomerById(int id) {
        try{
            Optional<Customer> customer =  customerRepository.findById((long) id);
            if(!customer.isPresent()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ServiceResponse<>("Customer not found", null, null, false));
            }
            return ResponseEntity.ok(new ServiceResponse<>("Customer found", customer, null, true));
        } catch (Exception ex){
            return HandleError("Finding", ex);
        }
    }

    @Override
    public ResponseEntity<ServiceResponse<Customer>> UpdateCustomer(CustomerUpdateRequestDTO customer) {
        try{
            Optional<Customer> existingcustomerOptional =  customerRepository.findById(customer.getId());
            if(!existingcustomerOptional.isPresent()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ServiceResponse<>("Customer not found", null, null, false));
            }
            Customer existingcustomer = existingcustomerOptional.get();
            existingcustomer.setName(customer.getName());
            existingcustomer.setAddress(customer.getAddress());
            existingcustomer.setInactive(true);
            customerRepository.save(existingcustomer);
            return ResponseEntity.ok(new ServiceResponse<>("Customer saved successfully", existingcustomer, null, true));
        } catch (Exception ex){
            return HandleError("Updating", ex);
        }
    }

    @Override
    public ResponseEntity<ServiceResponse<Customer>> DeleteCustomer(int id) {
        try{
            Optional<Customer> customer =  customerRepository.findById((long) id);
            if(!customer.isPresent()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ServiceResponse<>("Customer not found", null, null, false));
            }
            customerRepository.delete(customer.get());
            return ResponseEntity.ok(new ServiceResponse<>("Customer Deleted", customer.get(), null, true));
        } catch (Exception ex){
            return HandleError("Deleting", ex);
        }
    }
}
