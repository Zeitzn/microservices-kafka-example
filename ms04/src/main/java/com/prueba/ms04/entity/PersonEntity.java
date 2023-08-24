package com.prueba.ms04.entity;
import com.ms.commons.model.XmlModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "person")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "file_name", length = 50)
    private String fileName;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "last_name", length = 100)
    private String lastName;

    @Column(name = "city", length = 50)
    private String city;

    @Column(name = "country", length = 50)
    private String country;

    @Column(name = "first_name2", length = 50)
    private String firstName2;

    @Column(name = "last_name2", length = 100)
    private String lastName2;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "age")
    private Integer age;

    @Column(name = "random")
    private Integer random;

    @Column(name = "random_float")
    private String randomFloat;

    @Column(name = "bool")
    private Boolean bool;

    @Column(name = "date", length = 20)
    private String date;

    @Column(name = "reg_ex")
    private String regEx;

    @Column(name = "enum", length = 20)
    private String enumValue;

    @Column(name = "elt_list")
    private String eltList;

    @Column(name = "created_date")
    private LocalDateTime createdDate;
    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    @PrePersist
    public void prePersist() {
        createdDate = LocalDateTime.now();
        modifiedDate = LocalDateTime.now();
    }

    public static PersonEntity fromModel(XmlModel xmlModel) {
        String eltList = String.join(",", xmlModel.getEltList());
        return PersonEntity.builder()
                .fileName(xmlModel.getFileName())
                .firstName(xmlModel.getFirstName())
                .lastName(xmlModel.getLastName())
                .city(xmlModel.getCity())
                .country(xmlModel.getCountry())
                .firstName2(xmlModel.getFirstName2())
                .lastName2(xmlModel.getLastName2())
                .email(xmlModel.getEmail())
                .age(xmlModel.getAge())
                .random(xmlModel.getRandom())
                .randomFloat(xmlModel.getRandomFloat().toString())
                .bool(xmlModel.getBool())
                .date(xmlModel.getDate())
                .regEx(xmlModel.getRegEx())
                .enumValue(xmlModel.getEnumValue())
                .eltList(eltList)
                .build();
    }
}