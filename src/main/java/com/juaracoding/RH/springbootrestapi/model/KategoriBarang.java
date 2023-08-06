package com.juaracoding.RH.springbootrestapi.model;/*
IntelliJ IDEA 2022.3.1 (Community Edition)
Build #IC-223.8214.52, built on December 20, 2022
@Author Rhay Riswan Hadiyanto
Java Developer
Created on 01/08/2023 14:11
@Last Modified 01/08/2023 14:11
Version 1.0
*/

import javax.persistence.*;


@Entity
@Table (name = "MstKategoriBarang")
public class KategoriBarang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdKategoriBarang")
    private Long idKategoriBarang;

    @Column(name = "KategoriBarang")
    private String kategoriBarang;

    public Long getIdKategoriBarang() {
        return idKategoriBarang;
    }

    public void setIdKategoriBarang(Long idKategoriBarang) {
        this.idKategoriBarang = idKategoriBarang;
    }

    public String getKategoriBarang() {
        return kategoriBarang;
    }

    public void setKategoriBarang(String kategoriBarang) {
        this.kategoriBarang = kategoriBarang;
    }
}
