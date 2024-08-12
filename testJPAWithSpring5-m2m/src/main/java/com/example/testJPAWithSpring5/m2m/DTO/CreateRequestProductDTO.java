package com.example.testJPAWithSpring5.m2m.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level =  AccessLevel.PRIVATE)
public class CreateRequestProductDTO {
    @NotNull(message = "The productName is required.")
    String productName;
    @NotNull(message = "The category is required.")
    String category;
}
