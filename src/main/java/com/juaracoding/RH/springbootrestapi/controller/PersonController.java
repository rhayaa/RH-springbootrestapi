package com.juaracoding.RH.springbootrestapi.controller;/*
IntelliJ IDEA 2022.3.1 (Community Edition)
Build #IC-223.8214.52, built on December 20, 2022
@Author Rhay Riswan Hadiyanto
Java Developer
Created on 03/08/2023 21:35
@Last Modified 03/08/2023 21:35
Version 1.0
*/

import com.juaracoding.RH.springbootrestapi.model.Person;
import com.juaracoding.RH.springbootrestapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/person")
public class PersonController {


    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/v1/save")
    public ResponseEntity<Object> save(@RequestBody Person person, WebRequest request){

        return personService.save(person,request);
    }

    @PutMapping("/v1/upd/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") Long id,
                                         @RequestBody Person person,
                                         WebRequest request){

        return personService.update(id,person,request);
    }

    @DeleteMapping("/v1/upd/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value="id") Long id, WebRequest request){

        return personService.delete(id,request);
    }

}