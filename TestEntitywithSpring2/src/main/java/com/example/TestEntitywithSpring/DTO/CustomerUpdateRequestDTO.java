package com.example.TestEntitywithSpring.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerUpdateRequestDTO {
    private Long Id;
    private String name;
    private String address;
}
