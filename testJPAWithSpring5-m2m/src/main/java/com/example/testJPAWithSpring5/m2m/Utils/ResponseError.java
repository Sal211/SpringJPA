package com.example.testJPAWithSpring5.m2m.Utils;

import org.springframework.http.ResponseEntity;

public class ResponseError {
    public static  <T> ResponseEntity<BuilderResponse<T>> HandleError(String msg, Exception ex) {
        return ResponseEntity.status(500).body(new BuilderResponse<>("Error " +msg + "Customer",ex.getMessage(),false,null));
    }
}
