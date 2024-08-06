package com.example.testEntityWithSpring3.Utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ServiceResponse<T> {
    private T Data;
    private String Error;
    private String Message;
    private Boolean Success;
}
