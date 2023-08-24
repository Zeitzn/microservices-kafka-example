package com.prueba.ms05.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class XmlData {
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
    private Float randomFloat;
    private Boolean bool;
    private String date;
    private String regEx;
    private String enumValue;
    private List<String> eltList;
}
