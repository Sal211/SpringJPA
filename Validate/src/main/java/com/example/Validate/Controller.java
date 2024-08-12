package com.example.Validate;

import com.example.Validate.DTO.CreateReservationDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class Controller {
    @PostMapping("/post")
    public ResponseEntity<?> post(@Valid @RequestBody CreateReservationDto obj){
        return ResponseEntity.ok(obj);
    }

}
