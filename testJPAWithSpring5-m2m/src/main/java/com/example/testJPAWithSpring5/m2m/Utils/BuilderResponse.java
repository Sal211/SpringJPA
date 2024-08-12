package com.example.testJPAWithSpring5.m2m.Utils;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class BuilderResponse<T> {
    String Message;
    String Error;
    Boolean success;
    T Data ;
}
