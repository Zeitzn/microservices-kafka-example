package com.prueba.ms04.controller;

import com.prueba.ms04.dto.response.PersonResponse;
import com.prueba.ms04.entity.PersonEntity;
import com.prueba.ms04.service.IPersonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*", methods = { RequestMethod.GET, RequestMethod.OPTIONS })
@RestController
@RequestMapping(value = { "/api/v1/xml"})
public class PersonController {
    private final IPersonService service;

    public PersonController(IPersonService service) {
        this.service = service;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<PersonResponse>> findPaginated(Pageable pageable) {
        Page<PersonEntity> result = service.findAll(pageable);
        Page<PersonResponse> response = result.map(PersonEntity::toDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<PersonResponse>> search(
            @RequestParam(required = false) String value,
            Pageable pageable
    ) {
        Page<PersonEntity> result = service.search(value, pageable);
        Page<PersonResponse> response = result.map(PersonEntity::toDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
