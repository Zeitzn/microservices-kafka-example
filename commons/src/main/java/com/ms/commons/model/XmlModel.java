package com.ms.commons.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class XmlModel {
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
