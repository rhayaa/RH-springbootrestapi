package com.juaracoding.RH.springbootrestapi.model;/*
IntelliJ IDEA 2022.3.1 (Community Edition)
Build #IC-223.8214.52, built on December 20, 2022
@Author Rhay Riswan Hadiyanto
Java Developer
Created on 01/08/2023 7:24
@Last Modified 01/08/2023 7:24
Version 1.0
*/

import javax.persistence.*;

@Entity
@Table(name = "JenisKelamin")


public class JenisKelamin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDJenisKelamin")
    private int idJenisKelamin;
    @Column(name = "JenisKelamin")
    private String jenisKelamin;


    public Integer getIdJenisKelamin() {
        return idJenisKelamin;
    }

    public void setIdJenisKelamin(Integer idJenisKelamin) {
        this.idJenisKelamin = idJenisKelamin;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }
}
