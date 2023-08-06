package com.juaracoding.RH.springbootrestapi.controller;/*
IntelliJ IDEA 2022.3.1 (Community Edition)
Build #IC-223.8214.52, built on December 20, 2022
@Author Rhay Riswan Hadiyanto
Java Developer
Created on 02/08/2023 10:34
@Last Modified 02/08/2023 10:34
Version 1.0
*/
import com.juaracoding.RH.springbootrestapi.configuration.ConfigSMTPConfiguration;
import com.juaracoding.RH.springbootrestapi.dto.BarangDTO;
import com.juaracoding.RH.springbootrestapi.model.Barang;
import com.juaracoding.RH.springbootrestapi.repo.BarangRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/barang")
public class BarangController {
    @Autowired
    BarangRepo barangRepo;
    @Autowired
    ModelMapper modelMapper;
    @GetMapping("/list")
    public List<BarangDTO> getListBarang(@RequestBody BarangDTO barangDto)
    {
        List<Barang> barangList = barangRepo.findAll();
        List<BarangDTO> listBarangDTO = modelMapper.map(barangList, new TypeToken<List<BarangDTO>>() {}.getType());

        return listBarangDTO;
    }
    @GetMapping("/callconfig")
    public String getConfig()
    {
        System.out.println(ConfigSMTPConfiguration.getEmailHost());
        System.out.println(ConfigSMTPConfiguration.getEmailPassword());

        return ConfigSMTPConfiguration.getEmailHost();
    }
}
