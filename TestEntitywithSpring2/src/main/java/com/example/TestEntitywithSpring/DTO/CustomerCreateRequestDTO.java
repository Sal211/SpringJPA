package com.example.TestEntitywithSpring.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomerCreateRequestDTO {
    private String name;
    private String address;
}
