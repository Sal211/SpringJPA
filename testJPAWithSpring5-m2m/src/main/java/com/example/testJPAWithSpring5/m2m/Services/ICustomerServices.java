package com.example.testJPAWithSpring5.m2m.Services;

import com.example.testJPAWithSpring5.m2m.DTO.CreateRequestCustomerDTO;
import com.example.testJPAWithSpring5.m2m.DTO.UpdateRequestCustomerDTO;
import com.example.testJPAWithSpring5.m2m.Utils.BusinessExecption;
import org.springframework.http.ResponseEntity;

public interface ICustomerServices {
    ResponseEntity<?> FindCustomerByName(String name) throws BusinessExecption;
    ResponseEntity<?> FindAllCustomers();
    ResponseEntity<?> PostCustomer(CreateRequestCustomerDTO customer)  ;
    ResponseEntity<?> DeleteCustomer(int id) throws BusinessExecption;
    ResponseEntity<?> UpdateCustomer(UpdateRequestCustomerDTO customer) throws BusinessExecption;
}
