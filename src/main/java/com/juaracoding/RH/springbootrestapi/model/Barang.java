package com.juaracoding.RH.springbootrestapi.model;/*
IntelliJ IDEA 2022.3.1 (Community Edition)
Build #IC-223.8214.52, built on December 20, 2022
@Author Rhay Riswan Hadiyanto
Java Developer
Created on 01/08/2023 14:16
@Last Modified 01/08/2023 14:16
Version 1.0
*/
//import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "MstBarang")
public class Barang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdBarang")

    private Long idBarang;

    @Column(name = "NamaBarang")
    private String namaBarang;

    @Column(name = "Merk")
    private String merk;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IdKategoriBarang", referencedColumnName = "IdKategoriBarang")
    private KategoriBarang kategoriBarang;

    public Long getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(Long idBarang) {
        this.idBarang = idBarang;
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

    public KategoriBarang getKategoriBarang() {
        return kategoriBarang;
    }

    public void setKategoriBarang(KategoriBarang kategoriBarang) {
        this.kategoriBarang = kategoriBarang;
    }
}
