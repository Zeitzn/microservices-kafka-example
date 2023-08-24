package com.prueba.ms04.service.impl;

import com.prueba.ms04.entity.PersonEntity;
import com.prueba.ms04.repository.IPersonRepository;
import com.prueba.ms04.service.IPersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PersonServiceImpl implements IPersonService {
    private final IPersonRepository repository;

    public PersonServiceImpl(IPersonRepository repository) {
        this.repository = repository;
    }
    @Override
    public Page<PersonEntity> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }


    @Override
    public Page<PersonEntity> search(String value, Pageable pageable) {
        ExampleMatcher matcher = ExampleMatcher.matchingAny()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        PersonEntity filter = PersonEntity.builder()
                .fileName(value)
                .firstName(value)
                .lastName(value)
                .city(value)
                .country(value)
                .firstName2(value)
                .lastName2(value)
                .email(value)
                .randomFloat(value)
                .date(value)
                .regEx(value)
                .enumValue(value)
                .eltList(value)
                .build();

        Example<PersonEntity> exampleInfo = Example.of(filter, matcher);
        return repository.findAll(exampleInfo, pageable);
    }
}
