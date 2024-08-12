package com.example.testJPAWithSpring5.m2m.Services.Imp;

import com.example.testJPAWithSpring5.m2m.DTO.CreateRequestProductDTO;
import com.example.testJPAWithSpring5.m2m.DTO.UpdateRequestProductDTO;
import com.example.testJPAWithSpring5.m2m.Entity.ProductEntity;
import com.example.testJPAWithSpring5.m2m.Repository.ProductRepository;
import com.example.testJPAWithSpring5.m2m.Services.IProductServices;
import com.example.testJPAWithSpring5.m2m.Utils.BusinessExecption;
import com.example.testJPAWithSpring5.m2m.Utils.ResponseError;
import com.example.testJPAWithSpring5.m2m.Utils.BuilderResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductServiceImp implements IProductServices {
    private ProductRepository productRepository;
    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<?> FindProductById(int id) throws BusinessExecption {
        try{
            if (!productRepository.existsById(id)) throw new BusinessExecption("Product Not Found");
            var customer = productRepository.findById(id);
            return ResponseEntity.ok().body(new BuilderResponse<>("Getting Success",null,true,customer));
        }catch (Exception e){
            return ResponseError.HandleError("Getting" ,e);
        }
    }

    @Override
    public ResponseEntity<?> FindAllProduct() {
       try{
           var products = productRepository.findAll();
           return ResponseEntity.ok().body(new BuilderResponse<>("Getting Success",null,true,products));
       }catch (Exception e){
           return ResponseError.HandleError("Getting" ,e);
       }
    }

    @Override
    public ResponseEntity<?> PostProduct(CreateRequestProductDTO product) {
        try{
            ProductEntity productEntity = new ProductEntity();
            productEntity.setProductName(product.getProductName());
            productEntity.setCategory(product.getCategory());
            productRepository.save(productEntity);
            return ResponseEntity.ok().body(new BuilderResponse<>("Posting Success",null,true,null));
        }catch (Exception e){
            return ResponseError.HandleError("Posting" ,e);
        }
    }

    @Override
    public ResponseEntity<?> DeleteProduct(int id) throws BusinessExecption {
        try{
            if (!productRepository.existsById(id)) throw new BusinessExecption("Product Not Found");
            productRepository.deleteById(id);
            return ResponseEntity.ok().body(new BuilderResponse<>("Deleting Success",null,true,null));
        }catch (Exception ex) {
            return ResponseError.HandleError("Deleting",ex);
        }
    }

    @Override
    public ResponseEntity<?> UpdateProduct(UpdateRequestProductDTO product) throws BusinessExecption {
        try{
            ProductEntity existingProduct = productRepository.findById(product.getId()).orElse(null);
            if(existingProduct == null) throw new BusinessExecption("Product Not Found");
            existingProduct.setProductName(product.getProductName());
            existingProduct.setCategory(product.getCategory());
            productRepository.save(existingProduct);
            return ResponseEntity.ok().body(new BuilderResponse<>("Updating Success",null,true,null));
        }catch (Exception ex) {
            return ResponseError.HandleError("Adding",ex);
        }
    }
}
