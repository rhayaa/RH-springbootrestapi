package com.juaracoding.RH.springbootrestapi.dto;/*
IntelliJ IDEA 2022.3.1 (Community Edition)
Build #IC-223.8214.52, built on December 20, 2022
@Author Rhay Riswan Hadiyanto
Java Developer
Created on 02/08/2023 11:28
@Last Modified 02/08/2023 11:28
Version 1.0
*/

public class BarangDTO {

    private String namaBarang;
    private String merk;

    private KategoriBarangDTO kategoriBarang;

    public KategoriBarangDTO getKategoriBarang() {
        return kategoriBarang;
    }

    public void setKategoriBarang(KategoriBarangDTO kategoriBarang) {
        this.kategoriBarang = kategoriBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }
}
