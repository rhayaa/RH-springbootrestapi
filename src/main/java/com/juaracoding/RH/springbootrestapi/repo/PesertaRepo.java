package com.juaracoding.RH.springbootrestapi.repo;/*
IntelliJ IDEA 2022.3.1 (Community Edition)
Build #IC-223.8214.52, built on December 20, 2022
@Author Rhay Riswan Hadiyanto
Java Developer
Created on 28/07/2023 9:11
@Last Modified 28/07/2023 9:11
Version 1.0
*/

import com.juaracoding.RH.springbootrestapi.model.Peserta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface PesertaRepo extends JpaRepository <Peserta, Integer> {
    @Override
    <S extends Peserta> S save(S entity);

    List<Peserta> findByNama (String strNama);

    List<Peserta> findTop4ByBatchAndAlamatContaining(String batch, String alamatMengandung);

    List<Peserta> findTop2ByBatch(String batch);

    void deleteByNama(String strNama);
    int countByBatch(String batch);

}
