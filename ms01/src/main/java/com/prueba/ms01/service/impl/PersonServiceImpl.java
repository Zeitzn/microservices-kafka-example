package com.prueba.ms01.service.impl;

import com.prueba.ms01.entity.PersonEntity;
import com.prueba.ms01.repository.IPersonRepository;
import com.prueba.ms01.service.IPersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@Service
public class PersonServiceImpl implements IPersonService {
    private final IPersonRepository repository;

    public PersonServiceImpl(IPersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(PersonEntity person) {
        Optional<PersonEntity> existingPerson = findByFileName(person.getFileName());
        existingPerson.ifPresent(personEntity -> {
            person.setId(personEntity.getId());
            person.setModifiedDate(LocalDateTime.now());
            person.setCreatedDate(personEntity.getCreatedDate());
        });
        repository.save(person);
    }

    @Override
    public Optional<PersonEntity> findByFileName(String fileName) {
        return repository.findByFileName(fileName);
    }
}
