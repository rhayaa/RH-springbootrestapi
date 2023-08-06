package com.juaracoding.RH.springbootrestapi.controller;/*
IntelliJ IDEA 2022.3.1 (Community Edition)
Build #IC-223.8214.52, built on December 20, 2022
@Author Rhay Riswan Hadiyanto
Java Developer
Created on 06/08/2023 9:41
@Last Modified 06/08/2023 9:41
Version 1.0
*/

import com.juaracoding.RH.springbootrestapi.model.Person;
import com.juaracoding.RH.springbootrestapi.model.TugasA;
import com.juaracoding.RH.springbootrestapi.service.PersonService;
import com.juaracoding.RH.springbootrestapi.service.TugasAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@RestController
@RequestMapping("/api/tugasA")
public class TugasAController {

    private TugasAService tugasAService;

    @Autowired
    public TugasAController(TugasAService tugasAService) {
        this.tugasAService = tugasAService;
    }

    @PostMapping("/v2/save")
    public ResponseEntity<Object> save(@RequestBody TugasA tugasA, WebRequest request){

        return tugasAService.save(tugasA,request);
    }

    @PutMapping("/v2/upd/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") String id,
                                         @RequestBody TugasA tugasA,
                                         WebRequest request){

        return tugasAService.update(id,tugasA,request);
    }

}
