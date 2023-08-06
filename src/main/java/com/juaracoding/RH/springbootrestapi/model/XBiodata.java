package com.juaracoding.RH.springbootrestapi.model;/*
IntelliJ IDEA 2022.3.1 (Community Edition)
Build #IC-223.8214.52, built on December 20, 2022
@Author Rhay Riswan Hadiyanto
Java Developer
Created on 25/07/2023 13:52
@Last Modified 25/07/2023 13:52
Version 1.0
*/

public class XBiodata {

    private Long idBiodata;
    private String fullName;

    public void setIdBiodata(Long idBiodata) {
        this.idBiodata = idBiodata;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getIdBiodata() {
        return idBiodata;
    }

    public String getFullName() {
        return fullName;
    }

}
