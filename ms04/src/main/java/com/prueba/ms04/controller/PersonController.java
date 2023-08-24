package com.prueba.ms04.controller;

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
    public ResponseEntity<Page<PersonEntity>> findPaginated(Pageable pageable) {
        return new ResponseEntity<>(service.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<PersonEntity>> search(
            @RequestParam(required = false) String value,
            Pageable pageable
    ) {

        return new ResponseEntity<>(service.search(value, pageable), HttpStatus.OK);
    }
}
