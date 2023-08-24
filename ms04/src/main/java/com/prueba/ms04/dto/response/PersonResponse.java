package com.prueba.ms04.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonResponse {
    private String fileName;
    private String firstName;
    private String lastName;
    private String city;
    private String country;
    private String firstName2;
    private String lastName2;
    private String email;
    private Integer age;
    private Integer random;
    private String randomFloat;
    private Boolean bool;
    private String date;
    private String regEx;
    private String enumValue;
    private String eltList;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}
