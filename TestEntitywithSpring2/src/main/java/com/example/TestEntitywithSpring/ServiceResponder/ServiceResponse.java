package com.example.TestEntitywithSpring.ServiceResponder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ServiceResponse<T> {
    private String message;
    private T data;
    private String Error;
    private Boolean success;

}
