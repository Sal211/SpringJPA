package com.example.testJPAWithSpring5.m2m.Utils;

public class BusinessExecption extends RuntimeException {
    private static final long serialVersionUID = 14784847974764L;
    public BusinessExecption(String message) {
        super(message);
    }
}
