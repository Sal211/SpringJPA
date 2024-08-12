package com.example.Validate.DTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateReservationDto {
    @NotNull(message = "The number of bags is required.")
    @Min(value = 1, message = "The number of bags must be greater than 0")
    @Max(value = 3, message = "The number of bags must be greater than 3")
    private int bagsCount;
    @NotNull
    private String Name;
}
