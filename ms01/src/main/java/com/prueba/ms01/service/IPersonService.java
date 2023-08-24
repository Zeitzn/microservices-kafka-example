package com.prueba.ms01.service;

import com.prueba.ms01.entity.PersonEntity;

import java.util.Optional;

public interface IPersonService {
    public void save(PersonEntity person);

    Optional<PersonEntity> findByFileName(String fileName);
}
