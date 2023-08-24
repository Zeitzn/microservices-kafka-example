package com.prueba.ms04.entity;
import com.ms.commons.model.XmlModel;
import com.prueba.ms04.dto.response.PersonResponse;
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

    public static PersonResponse toDto(PersonEntity person) {
        return PersonResponse.builder()
                .fileName(person.getFileName())
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .city(person.getCity())
                .country(person.getCountry())
                .firstName2(person.getFirstName2())
                .lastName2(person.getLastName2())
                .email(person.getEmail())
                .age(person.getAge())
                .random(person.getRandom())
                .randomFloat(person.getRandomFloat())
                .bool(person.getBool())
                .date(person.getDate())
                .regEx(person.getRegEx())
                .enumValue(person.getEnumValue())
                .eltList(person.getEltList())
                .createdDate(person.getCreatedDate())
                .modifiedDate(person.getModifiedDate())
                .build();
    }

}