package com.example.testJPAWithSpring5.m2m.Utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class BusinessExceptionHandler {
    @ExceptionHandler(BusinessExecption.class)
    public ResponseEntity<BuilderResponse<?>> handleBusinessExecption(Exception ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new BuilderResponse<>("Customer Not Found", ex.getMessage(), false, null));
    }


}
