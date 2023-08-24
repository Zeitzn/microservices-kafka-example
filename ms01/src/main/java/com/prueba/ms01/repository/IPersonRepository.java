package com.prueba.ms01.repository;

import com.prueba.ms01.entity.PersonEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPersonRepository extends CrudRepository<PersonEntity, Long> {
    Optional<PersonEntity> findByFileName(String fileName);
}
