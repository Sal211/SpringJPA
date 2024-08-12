package com.example.testJPAWithSpring5.m2m.Controller;

import com.example.testJPAWithSpring5.m2m.DTO.CreateRequestProductDTO;
import com.example.testJPAWithSpring5.m2m.DTO.UpdateRequestProductDTO;
import com.example.testJPAWithSpring5.m2m.Services.Imp.ProductServiceImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/Product")
public class ProductCustomer {
    @Autowired
    private ProductServiceImp productServiceImp;
    @GetMapping("/GetProduct")
    public ResponseEntity<?> GetProduct() {
        return productServiceImp.FindAllProduct();
    }
    @GetMapping("/GetProductById/{id}")
    public ResponseEntity<?> GetProductById(@PathVariable int id) {
        return productServiceImp.FindProductById(id);
    }
    @PostMapping("/PostProduct")
    public ResponseEntity<?> PostProduct(@Valid @RequestBody CreateRequestProductDTO product){
        return productServiceImp.PostProduct(product);
    }
    @PostMapping("/UpdateProduct")
    public ResponseEntity<?> UpdateProduct(@Valid @RequestBody UpdateRequestProductDTO product){
        return productServiceImp.UpdateProduct(product);
    }
    @PostMapping("/DeleteProduct/{id}")
    public ResponseEntity<?> DeleteProduct(@PathVariable int id) {
        return productServiceImp.DeleteProduct(id);
    }
}
