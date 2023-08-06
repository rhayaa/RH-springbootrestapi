package com.juaracoding.RH.springbootrestapi.model;/*
IntelliJ IDEA 2022.3.1 (Community Edition)
Build #IC-223.8214.52, built on December 20, 2022
@Author Rhay Riswan Hadiyanto
Java Developer
Created on 05/08/2023 12:55
@Last Modified 05/08/2023 12:55
Version 1.0
*/


import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.BitSet;
import java.util.Date;

@Entity
@Table(name = "MstTugasA")
public class TugasA {

    @Id
    @Column(name = "IDTugasA")
    @NotNull(message = "ID TIDAK BOLEH NULL")
    private String idTugasA;

    @Column(name = "Nama", length = 40, nullable = false)
    @Length(message = "NAMA Minimal 3 Maksimal 40 ",min = 3, max = 40)
    @NotNull(message = "NAMA TIDAK BOLEH NULL")
    @NotEmpty(message = "NAMA TIDAK BOLEH KOSONG")
    @NotBlank(message = "NAMA TIDAK BOLEH BLANK")
    private String nama;

    @Column(name = "Alamat", length = 500, nullable = false)
    @Length(message = "Alamat Minimal 5 Maksimal 40 ",min = 5, max = 500)
    @NotNull(message = "Alamat TIDAK BOLEH NULL")
    @NotEmpty(message = "Alamat TIDAK BOLEH KOSONG")
    @NotBlank(message = "Alamat TIDAK BOLEH BLANK")
    private String alamat;

    @Column(name = "TanggalLahir")
    @NotNull(message = "Tanggal LAHIR TIDAK BOLEH NULL")
    @NotEmpty(message = "TANGGAL LAHIR TIDAK BOLEH KOSONG")
    @NotBlank(message = "TANGGAL LAHIR TIDAK BOLEH BLANK")
    private LocalDate tanggalLahir;

    @Column(name = "JenisKelamin")
    @NotNull(message = "JENIS KELAMIN TIDAK BOLEH NULL")
    @NotEmpty(message = "JENIS KELAMIN TIDAK BOLEH KOSONG")
    @NotBlank(message = "JENIS KELAMIN TIDAK BOLEH BLANK")
    private Character jenisKelamin;

    @Column(name = "MasihHidup")
    @NotNull(message = "TIDAK BOLEH NULL")
    @NotEmpty(message = "TIDAK BOLEH KOSONG")
    @NotBlank(message = "TIDAK BOLEH BLANK")
    private Boolean masihHidup;

    @Column(name = "CreatedDate",nullable = false)
    @NotNull(message = "TIDAK BOLEH NULL")
    private Date createdDate = new Date();

    @Column(name = "CreatedBy",nullable = false)
    @NotNull(message = "TIDAK BOLEH NULL")
    private Integer createdBy ;

    @Column(name = "ModifiedDate")
    private Date modifiedDate;

    @Column(name = "ModifiedBy")
    private Integer modifiedBy ;

    @Column(name = "IsDelete")
    @NotNull(message = "TIDAK BOLEH NULL")
    private Byte isDelete = 1;


    public String getIdTugasA() {
        return idTugasA;
    }

    public void setIdTugasA(String idTugasA) {
        this.idTugasA = idTugasA;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public LocalDate getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(LocalDate tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public Character getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(Character jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public Boolean getMasihHidup() {
        return masihHidup;
    }

    public void setMasihHidup(Boolean masihHidup) {
        this.masihHidup = masihHidup;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }
}
