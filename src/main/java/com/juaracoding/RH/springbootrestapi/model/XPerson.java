package com.juaracoding.RH.springbootrestapi.model;/*
IntelliJ IDEA 2022.3.1 (Community Edition)
Build #IC-223.8214.52, built on December 20, 2022
@Author Rhay Riswan Hadiyanto
Java Developer
Created on 24/07/2023 21:04
@Last Modified 24/07/2023 21:04
Version 1.0
*/

import java.time.LocalDate;
import java.util.List;

public class XPerson {

    private Long idPerson;
    private String namaLengkap;
    private LocalDate tanggalLahir;
    private String email;

    private List<XData> xDataList;

    private XBarang xBarang;

    public XBarang getxBarang() {
        return xBarang;
    }

    public void setxBarang(XBarang xBarang) {
        this.xBarang = xBarang;
    }

    public List<XData> getxDataList() {
        return xDataList;
    }

    public void setxDataList(List<XData> xDataList) {
        this.xDataList = xDataList;
    }

    public Long getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Long idPerson) {
        this.idPerson = idPerson;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public LocalDate getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(LocalDate tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



}
