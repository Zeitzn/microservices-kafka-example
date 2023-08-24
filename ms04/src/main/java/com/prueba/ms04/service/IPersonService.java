package com.prueba.ms04.service;

import com.prueba.ms04.entity.PersonEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPersonService {
    Page<PersonEntity> findAll(Pageable pageable);
    Page<PersonEntity> search(String value, Pageable pageable);
}
