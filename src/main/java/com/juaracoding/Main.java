package com.juaracoding;/*
IntelliJ IDEA 2022.3.1 (Community Edition)
Build #IC-223.8214.52, built on December 20, 2022
@Author Rhay Riswan Hadiyanto
Java Developer
Created on 24/07/2023 21:21
@Last Modified 24/07/2023 21:21
Version 1.0
*/

import com.juaracoding.RH.springbootrestapi.model.XData;
import com.juaracoding.RH.springbootrestapi.model.XPerson;

import java.time.LocalDate;
import java.util.*;
public class Main {

    public static void main(String[] args) {

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

        Map<String, Object> map = new HashMap<String,Object>();
        map.put("idPerson",1);
        map.put("namaLengkap","Hakim");
        map.put("tanggalLahir","2005-08-17");
        map.put("email","hakim182@gmail.com");
        map.put("xDataList",list);

        XPerson xPerson = new XPerson();
        xPerson.setIdPerson(1L);
        xPerson.setNamaLengkap("Hakim");
        xPerson.setEmail("hakim182@gmail.com");
        xPerson.setTanggalLahir(LocalDate.now());
        xPerson.setxDataList(list);

        System.out.println(map.get("idPerson"));
        System.out.println(xPerson.getIdPerson());

        /*
            {
                "idPerson" : 1,
                "namaLengkap" : "Hakim",
                "tanggalLahir" : "2005-08-17",
                "email" : "hakim182@gmail.com"
            }
         */

        /*
            int intX = 2;
            "intX" , 2
            setIntX(2)
            "intX" : 2
         */

    }

}
