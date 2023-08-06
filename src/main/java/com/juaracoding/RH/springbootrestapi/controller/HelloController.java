package com.juaracoding.RH.springbootrestapi.controller;/*
IntelliJ IDEA 2022.3.1 (Community Edition)
Build #IC-223.8214.52, built on December 20, 2022
@Author Rhay Riswan Hadiyanto
Java Developer
Created on 24/07/2023 12:06
@Last Modified 24/07/2023 12:06
Version 1.0
*/
import com.juaracoding.RH.springbootrestapi.model.XBarang;
import com.juaracoding.RH.springbootrestapi.model.XBiodata;
import com.juaracoding.RH.springbootrestapi.model.CalonPeserta;
import com.juaracoding.RH.springbootrestapi.model.XData;
import com.juaracoding.RH.springbootrestapi.model.XPerson;
import org.springframework.web.bind.annotation.*;

//upload gambar
import com.juaracoding.RH.springbootrestapi.util.FileUtility;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/permisi")
    public Object firstPage() {

        XData xData = new XData();
        xData.setId(193553L);
        xData.setNama("Tessy Wahyuni");
        xData.setJenisKelamin("Pria");
        xData.setUmur(78);
        return xData;
    }

    @GetMapping("/permisi2")
    public Object secondPage() {

        List<XData> list = new ArrayList<>();
        XData xData = new XData();
        xData.setId(111L);
        xData.setNama("Petrus");
        xData.setUmur(22);
        xData.setJenisKelamin("pria");
        list.add(xData);

        xData = new XData();
        xData.setId(222L);
        xData.setNama("Riswan");
        xData.setUmur(25);
        xData.setJenisKelamin("pria");
        list.add(xData);

        xData = new XData();
        xData.setId(333L);
        xData.setNama("Fadhil");
        xData.setUmur(24);
        xData.setJenisKelamin("pria");
        list.add(xData);

        XBarang xBarang = new XBarang();
        xBarang.setIdBarang(1121L);
        xBarang.setNamaBarang("Barang Pecah Belah");

        XPerson xPerson = new XPerson();
        xPerson.setIdPerson(1L);
        xPerson.setNamaLengkap("Hakim");
        xPerson.setEmail("hakim182@gmail.com");
        xPerson.setTanggalLahir(LocalDate.now());
        xPerson.setxDataList(list);
        xPerson.setxBarang(xBarang);

        List<XData> listXData = xPerson.getxDataList();
        for(int i=0;i<listXData.size();i++)
        {
            System.out.println("ID : "+listXData.get(i).getId());
            System.out.println("Nama : "+listXData.get(i).getNama());
            System.out.println("Umur : "+listXData.get(i).getUmur());
            System.out.println("JK : "+listXData.get(i).getJenisKelamin());
        }

        return xPerson;
    }

    @GetMapping("/punten")
    public Object pageKetiga() {

        XBiodata xbio = new XBiodata();
        xbio.setIdBiodata(111L);
        xbio.setFullName("hahahhaha");

        return xbio;

    }

    @PostMapping("/seleksi")
    public String seleksiCalonPeserta(@RequestBody CalonPeserta calon) {
        if (calon.getNilai() > 80 && calon.getUmur() >= 18 && calon.getUmur() <= 60) {
            return calon.getNama() + " lolos seleksi";
        } else {
            return calon.getNama() + " tidak lolos seleksi";
        }
    }

    @PostMapping("/seleksi2")
    public String seleksiCalonPeserta2(@RequestParam(value = "nama") String nama,
                                       @RequestParam(value = "umur") Integer umur,
                                       @RequestParam(value = "nilai") Integer nilai) {
        if (nilai > 80 && umur >= 18 && umur <= 60) {
            return nama + " lolos seleksi";
        } else {
            return nama + " tidak lolos seleksi";
        }
    }

    @PostMapping("/seleksi3/{nama}/{umur}/{nilai}")
    public String seleksiCalonPeserta3(@PathVariable(value = "nama") String nama,
                                       @PathVariable(value = "umur") Integer umur,
                                       @PathVariable(value = "nilai") Double nilai) {
        if (nilai > 80 && umur >= 18 && umur <= 60) {
            return nama + " lolos seleksi";
        } else {
            return nama + " tidak lolos seleksi";
        }
    }

    @PostMapping("/kirim-file")
    public String submitFile(@RequestParam(value = "kiriman") MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String uploadDir = "user-files/";
        FileUtility.saveFile(uploadDir, fileName, file);
        return "Berhasil mengunggah file " + fileName;
    }

}
