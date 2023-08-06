package com.juaracoding.RH.springbootrestapi.model;/*
IntelliJ IDEA 2022.3.1 (Community Edition)
Build #IC-223.8214.52, built on December 20, 2022
@Author Rhay Riswan Hadiyanto
Java Developer
Created on 28/07/2023 8:56
@Last Modified 28/07/2023 8:56
Version 1.0
*/
import javax.persistence.*;

@Entity
@Table (name = "Peserta")
public class Peserta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "ID")
    private Integer id;
    @Column(name = "Nama")
    private String nama;
    @Column(name = "Batch")
    private String batch;

    @Column(name = "Alamat")
    private String alamat;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDJenisKelamin", referencedColumnName = "IDJenisKelamin")
    private JenisKelamin idJenisKelamin;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public JenisKelamin getIdJenisKelamin() {
        return idJenisKelamin;
    }

    public void setIdJenisKelamin(JenisKelamin idJenisKelamin) {
        this.idJenisKelamin = idJenisKelamin;
    }
}
