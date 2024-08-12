package com.example.testJPAWithSpring5.m2m.Services.Imp;

import com.example.testJPAWithSpring5.m2m.DTO.CreateRequestCustomerDTO;
import com.example.testJPAWithSpring5.m2m.DTO.UpdateRequestCustomerDTO;
import com.example.testJPAWithSpring5.m2m.Entity.CustomerEntity;
import com.example.testJPAWithSpring5.m2m.Entity.ProductEntity;
import com.example.testJPAWithSpring5.m2m.Repository.CustomerRespository;
import com.example.testJPAWithSpring5.m2m.Repository.ProductRepository;
import com.example.testJPAWithSpring5.m2m.Services.ICustomerServices;
import com.example.testJPAWithSpring5.m2m.Utils.BusinessExecption;
import com.example.testJPAWithSpring5.m2m.Utils.ResponseError;
import com.example.testJPAWithSpring5.m2m.Utils.BuilderResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CustomerServiceImp implements ICustomerServices {
    private CustomerRespository customerRespository;
    private ProductRepository productRepository;
    public CustomerServiceImp(CustomerRespository customerRespository, ProductRepository productRepository) {
        this.customerRespository = customerRespository;
        this.productRepository = productRepository;
    }
    @Override
    public ResponseEntity<?> FindCustomerByName(String name) throws BusinessExecption {
        try{
            if (!customerRespository.existsByName(name)) throw new BusinessExecption("Customer Not Found");
            var customer = customerRespository.findByName(name);
            return ResponseEntity.ok().body(new BuilderResponse<>("Getting Success",null,true,customer));
        }catch (Exception ex) {
            return ResponseError.HandleError("Getting",ex) ;
        }
    }


    public ResponseEntity<?> FindAllCustomers ()   {
        try{
            var customers = customerRespository.findAll();
            return ResponseEntity.ok().body(new BuilderResponse<>("Getting Success",null,true,customers));
        }catch (Exception ex) {
            return ResponseError.HandleError("Getting",ex) ;
        }
    }
    @Override
    public ResponseEntity<?> PostCustomer(CreateRequestCustomerDTO customer) {
        try{
            Set<ProductEntity> products = new HashSet<>();
            var product = productRepository.findById(customer.getProductId());
            products.add(product.get());
            CustomerEntity newCustomer = new CustomerEntity();
            newCustomer.setName(customer.getName());
            newCustomer.setSex(customer.getSex());
            newCustomer.setProducts(products);
            customerRespository.save(newCustomer);
            return ResponseEntity.ok().body(new BuilderResponse<>("Posting Success",null,true,null));
        }catch (Exception ex) {
            return ResponseError.HandleError("Adding",ex);
        }
    }

    @Override
    public ResponseEntity<?> DeleteCustomer(int id) throws BusinessExecption {
        try{
            if(!customerRespository.existsById(id))  throw new BusinessExecption("Customer NotFound");
            customerRespository.deleteById(id);
            return ResponseEntity.ok().body(new BuilderResponse<>("Deleting Success",null,true,null));
        }catch (Exception ex) {
            return ResponseError.HandleError("Adding",ex);
        }
    }

    @Override
    public ResponseEntity<?> UpdateCustomer(UpdateRequestCustomerDTO customer) throws BusinessExecption {
        try{
            var product = productRepository.findById(customer.getProductId());
            CustomerEntity existingCustomer = customerRespository.findById(customer.getId()).orElse(null);
            if(existingCustomer == null)  throw  new BusinessExecption("Customer NotFound");
            existingCustomer.setName(customer.getName());
            existingCustomer.setSex(customer.getSex());
            existingCustomer.setProducts((Set<ProductEntity>) product.get());
            customerRespository.save(existingCustomer);
            return ResponseEntity.ok().body(new BuilderResponse<>("Updating Success",null,true,null));
        }catch (Exception ex) {
            return ResponseError.HandleError("Adding",ex);
        }
    }
}
