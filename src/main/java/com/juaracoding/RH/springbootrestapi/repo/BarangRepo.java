package com.juaracoding.RH.springbootrestapi.repo;/*
IntelliJ IDEA 2022.3.1 (Community Edition)
Build #IC-223.8214.52, built on December 20, 2022
@Author Rhay Riswan Hadiyanto
Java Developer
Created on 02/08/2023 10:29
@Last Modified 02/08/2023 10:29
Version 1.0
*/

import com.juaracoding.RH.springbootrestapi.model.Barang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarangRepo extends JpaRepository<Barang, Long> {
}
