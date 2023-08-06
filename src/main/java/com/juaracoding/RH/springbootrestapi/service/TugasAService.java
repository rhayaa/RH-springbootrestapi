package com.juaracoding.RH.springbootrestapi.service;/*
IntelliJ IDEA 2022.3.1 (Community Edition)
Build #IC-223.8214.52, built on December 20, 2022
@Author Rhay Riswan Hadiyanto
Java Developer
Created on 06/08/2023 9:06
@Last Modified 06/08/2023 9:06
Version 1.0
*/

import com.juaracoding.RH.springbootrestapi.configuration.OtherConfig;
import com.juaracoding.RH.springbootrestapi.handler.ResponseHandler;
import com.juaracoding.RH.springbootrestapi.model.TugasA;
import com.juaracoding.RH.springbootrestapi.repo.TugasARepo;
import com.juaracoding.RH.springbootrestapi.util.ConstantMessage;
import com.juaracoding.RH.springbootrestapi.util.LoggingFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.WebRequest;

import java.util.*;

@Service
@Transactional
public class TugasAService {

    private TugasARepo tugasARepo;

    private String[] strExceptionArr = new String[2];

    @Autowired
    public TugasAService(TugasARepo tugasARepo) {
        strExceptionArr[0] = "TugasAService";
        this.tugasARepo = tugasARepo;
    }

    public ResponseEntity<Object> save (TugasA tugasA, WebRequest request)
    {
        try {
            tugasARepo.save(tugasA);
        }catch (Exception e)
        {
            strExceptionArr[1] = "ResponseEntity<Object> save(TugasA tugasA, WebRequest request) -- LINE49";
            LoggingFile.exceptionStringz(strExceptionArr, e, OtherConfig.getFlagLogging());
            return new ResponseHandler().
                    generateResponse(ConstantMessage.ERROR_FAILED_CREATED,
                            HttpStatus.NOT_ACCEPTABLE,"","FE21002",request);
        }
        tugasA.setModifiedBy(12);
        tugasA.setModifiedDate(new Date());
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("token","uhaiwehiuaywe");
//        map.put("obj",person);

        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_CREATED,
                        HttpStatus.CREATED,map,null,request);
    }


    public ResponseEntity<Object> update(String id,TugasA tugasA, WebRequest request){

        try{
            TugasA optionalTugasA = tugasARepo.findById(id).orElseThrow(()->null);

            if(optionalTugasA==null)
            {
                return new ResponseHandler().
                        generateResponse(ConstantMessage.ERROR_DATA_NOT_FOUND,
                                HttpStatus.NOT_FOUND,"","FV21012",request);
            }

            optionalTugasA.setNama(tugasA.getNama());
            optionalTugasA.setAlamat(tugasA.getAlamat());
            optionalTugasA.setTanggalLahir(tugasA.getTanggalLahir());
            optionalTugasA.setModifiedBy(1);
            optionalTugasA.setModifiedDate(new Date());

        }catch(Exception e)
        {
            strExceptionArr[1] = "ResponseEntity<Object> update(Long id,Person person, WebRequest request) -- LINE74";
            LoggingFile.exceptionStringz(strExceptionArr, e, OtherConfig.getFlagLogging());
            return new ResponseHandler().
                    generateResponse(ConstantMessage.ERROR_FAILED_UPDATED,
                            HttpStatus.NOT_ACCEPTABLE,"","FE21011",request);
        }

        //SELECT * FROM MstPerson WHERE IdPerson = 1

        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_UPDATED,
                        HttpStatus.OK,"",null,request);
    }


    private void manualValidation(TugasA tugasA)
    {
        Map<String,Object> map = new HashMap<>();
        List<String> list = new ArrayList<String>();
        Boolean isValid = true;
        if(tugasA.getNama()==null)
        {
            list.add("Nama Depan Tidak Boleh Null");isValid = false;
        }else if(tugasA.getNama().equals(""))
        {
            list.add("Nama Depan Tidak Boleh Kosong");isValid = false;
        }else if(tugasA.getNama().matches("^\\s*$")){
            list.add("Nama Depan Tidak Boleh Blank");isValid = false;
        }


        if(tugasA.getNama().length()<4 && tugasA.getNama().length()>40 )
        {
            list.add("Nama Depan Minimal 3 Maksimal 40 Karakter");isValid = false;
        }

    }

}
