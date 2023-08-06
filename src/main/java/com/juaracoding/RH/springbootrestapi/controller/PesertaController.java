package com.juaracoding.RH.springbootrestapi.controller;/*
IntelliJ IDEA 2022.3.1 (Community Edition)
Build #IC-223.8214.52, built on December 20, 2022
@Author Rhay Riswan Hadiyanto
Java Developer
Created on 28/07/2023 9:03
@Last Modified 28/07/2023 9:03
Version 1.0
*/

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.juaracoding.RH.springbootrestapi.model.Peserta;
import com.juaracoding.RH.springbootrestapi.repo.PesertaRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/peserta")
public class PesertaController {

    @Autowired
    PesertaRepo pesertaRepo;

    //menampilkan data
    @GetMapping("/")
    public List<Peserta> getAllData() {
        List<Peserta> daftarPeserta = pesertaRepo.findAll();
        return daftarPeserta;
    }

    //input data
    @PostMapping("/")
    public String postData(@RequestBody Peserta peserta) {
        pesertaRepo.save(peserta);
        return peserta.getNama() + " berhasil ditambahkan";
    }

    //input data banyak
    @PostMapping("/batch")
    public String postData(@RequestBody List<Peserta> peserta) {
//        pesertaRepo.delete(peserta);
//        pesertaRepo.save(peserta);
        pesertaRepo.saveAll(peserta);
        return peserta.size()+" data berhasil ditambahkan";
    }

    //menampilkan data menurut id
    @GetMapping("/search-peserta-by-id")
    public Peserta searchPesertaById(@RequestParam(value = "id") Integer id) {
        Optional<Peserta> hasil = pesertaRepo.findById(id);

        return hasil.get();
    }

    //menamppilkan data menurut nama
    @GetMapping("/search-peserta-by-nama")
    public List<Peserta> searchPesertaByNama(@RequestParam(value = "nama") String nama) {
        List<Peserta> hasil = pesertaRepo.findByNama(nama);
        return hasil;
    }

    //delete by nama
    @PostMapping("/delete-peserta-by-nama")
    public String deletePesertaByNama(@RequestParam(value = "nama") String nama) {
        pesertaRepo.deleteByNama(nama);
        return "Peserta bernama " + nama + " berhasil dihapus";
    }

    //delete by id
    @DeleteMapping("/delete-peserta-by-nama/{id}")
    public String deletePesertaByNama(@PathVariable(value = "id") Integer id) {
        pesertaRepo.deleteById(id);
        return "Peserta dengan id " + id + " berhasil dihapus";
    }

    //menjumlahkan banyak data batch
    @GetMapping("/count-peserta-by-batch")
    public int countPesertaByBatch(@RequestParam(value = "batch") String batch) {
        int hasil = pesertaRepo.countByBatch(batch);
        return hasil;
    }

    //menampilkan data 2 colom
    @GetMapping("/search-4-peserta-by-batch-and-kota")
    public List<Peserta> searchPesertaByBatchAndKota(@RequestParam(value = "batch") String batch
            , @RequestParam(value = "alamat") String kota) {
        List<Peserta> hasil = pesertaRepo.findTop4ByBatchAndAlamatContaining(batch, kota);
        return hasil;
    }

    //menampilkan data dari berapa data teratas
    @GetMapping("/findtop/{id}")
    public List<Peserta> findTop2ByBatch(@PathVariable(value = "id") String strBatch) {
        List<Peserta> peserta = pesertaRepo.findTop2ByBatch(strBatch);
        return peserta;
    }

}
