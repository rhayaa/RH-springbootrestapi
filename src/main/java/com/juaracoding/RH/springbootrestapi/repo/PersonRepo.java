package com.juaracoding.RH.springbootrestapi.repo;/*
IntelliJ IDEA 2022.3.1 (Community Edition)
Build #IC-223.8214.52, built on December 20, 2022
@Author Rhay Riswan Hadiyanto
Java Developer
Created on 03/08/2023 21:25
@Last Modified 03/08/2023 21:25
Version 1.0
*/

import com.juaracoding.RH.springbootrestapi.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

//tends
public interface PersonRepo extends JpaRepository<Person,Long> {
}
