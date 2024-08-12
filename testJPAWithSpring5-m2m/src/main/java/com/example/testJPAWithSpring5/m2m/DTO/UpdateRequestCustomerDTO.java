package com.example.testJPAWithSpring5.m2m.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateRequestCustomerDTO {
    int id;
    @NotNull(message = "The name is required.")
    String name;
    @NotNull(message = "The sex is required.")
    String sex;
    @NotNull(message = "The productId is required.")
    int productId;
}
