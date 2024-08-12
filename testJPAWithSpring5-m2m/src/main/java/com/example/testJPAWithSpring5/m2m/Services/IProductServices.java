package com.example.testJPAWithSpring5.m2m.Services;

import com.example.testJPAWithSpring5.m2m.DTO.CreateRequestProductDTO;
import com.example.testJPAWithSpring5.m2m.DTO.UpdateRequestProductDTO;
import com.example.testJPAWithSpring5.m2m.Utils.BusinessExecption;
import org.springframework.http.ResponseEntity;

public interface IProductServices {
    ResponseEntity<?> FindProductById(int id) throws BusinessExecption;
    ResponseEntity<?> FindAllProduct();
    ResponseEntity<?> PostProduct(CreateRequestProductDTO product);
    ResponseEntity<?> DeleteProduct(int id ) throws BusinessExecption;
    ResponseEntity<?> UpdateProduct(UpdateRequestProductDTO product) throws BusinessExecption;

}
