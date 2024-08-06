package com.example.testEntityWithSpring3.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentCreateRequestDTO {
    @NotNull(message = "Name Should Not be Null!!!")
    private String name;
    private String gender;
}
