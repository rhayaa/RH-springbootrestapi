package com.juaracoding.RH.springbootrestapi.service;/*
IntelliJ IDEA 2022.3.1 (Community Edition)
Build #IC-223.8214.52, built on December 20, 2022
@Author Rhay Riswan Hadiyanto
Java Developer
Created on 03/08/2023 21:28
@Last Modified 03/08/2023 21:28
Version 1.0
*/

import com.juaracoding.RH.springbootrestapi.configuration.OtherConfig;
import com.juaracoding.RH.springbootrestapi.handler.ResponseHandler;
import com.juaracoding.RH.springbootrestapi.model.Person;
import com.juaracoding.RH.springbootrestapi.repo.PersonRepo;
import com.juaracoding.RH.springbootrestapi.util.ConstantMessage;
import com.juaracoding.RH.springbootrestapi.util.LoggingFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.WebRequest;
import java.util.*;

//import javax.transaction.Transactional;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/*
    Modul Code 21
    FV
    FE21032

 */
@Service
@Transactional
public class PersonService {

    private PersonRepo personRepo;

    private String[] strExceptionArr = new String[2];


    @Autowired
    public PersonService(PersonRepo personRepo) {
        strExceptionArr[0] = "PersonService";
        this.personRepo = personRepo;
    }

    //    @Transactional(rollbackOn = Exception.class)
    public ResponseEntity<Object> save(Person person, WebRequest request)
    {
        try{
            personRepo.save(person);
        }catch (Exception e)
        {
//            e.printStackTrace();
//            System.out.println(e.getMessage());
//            System.out.println(e.getCause());

            strExceptionArr[1] = "ResponseEntity<Object> save(Person person, WebRequest request) -- LINE49";
            LoggingFile.exceptionStringz(strExceptionArr, e, OtherConfig.getFlagLogging());
            return new ResponseHandler().
                    generateResponse(ConstantMessage.ERROR_FAILED_CREATED,
                            HttpStatus.NOT_ACCEPTABLE,"","FE21001",request);
        }
//        person.setNamaDepan("Nama depan");
//        person.setNamaBelakang("Nama Belakang");
        person.setModifiedBy(12L);
        person.setModifiedDate(new Date());
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("token","uhaiwehiuaywe");
//        map.put("obj",person);

        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_CREATED,
                        HttpStatus.CREATED,map,null,request);
    }


    public ResponseEntity<Object> update(Long id,Person person, WebRequest request){

        try{
            Person optionalPerson = personRepo.findById(id).orElseThrow(()->null);

            if(optionalPerson==null)
            {
                return new ResponseHandler().
                        generateResponse(ConstantMessage.ERROR_DATA_NOT_FOUND,
                                HttpStatus.NOT_FOUND,"","FV21011",request);
            }

            optionalPerson.setNamaBelakang(person.getNamaBelakang());
            optionalPerson.setNamaDepan(person.getNamaDepan());
            optionalPerson.setNamaTengah(person.getNamaTengah());
            optionalPerson.setAlamat(person.getAlamat());
            optionalPerson.setTanggalLahir(person.getTanggalLahir());
            optionalPerson.setModifiedBy(1L);
            optionalPerson.setModifiedDate(new Date());

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


    public ResponseEntity<Object> delete(Long id, WebRequest request){

        try{
            Person person = personRepo.findById(id).orElseThrow(()->null);
            if(person==null)
            {
                return new ResponseHandler().
                        generateResponse(ConstantMessage.ERROR_DATA_NOT_FOUND,
                                HttpStatus.NOT_FOUND,"","FV21021",request);
            }
            personRepo.deleteById(id);
        }catch (Exception e)
        {
            strExceptionArr[1] = "ResponseEntity<Object> delete(Long id, WebRequest request) -- LINE101";
            LoggingFile.exceptionStringz(strExceptionArr, e, OtherConfig.getFlagLogging());
            return new ResponseHandler().
                    generateResponse(ConstantMessage.ERROR_FAILED_UPDATED,
                            HttpStatus.NOT_ACCEPTABLE,"","FE21011",request);
        }

        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_DELETE,
                        HttpStatus.OK,"",null,request);

    }

    private void manualValidation(Person person)
    {
        Map<String,Object> map = new HashMap<>();
        List<String> list = new ArrayList<String>();
        Boolean isValid = true;
        if(person.getNamaDepan()==null)
        {
            list.add("Nama Depan Tidak Boleh Null");isValid = false;
        }else if(person.getNamaDepan().equals(""))
        {
            list.add("Nama Depan Tidak Boleh Kosong");isValid = false;
        }else if(person.getNamaDepan().matches("^\\s*$")){
            list.add("Nama Depan Tidak Boleh Blank");isValid = false;
        }
        if(person.getNamaTengah()==null)
        {
            list.add("Nama Tengah Tidak Boleh Null");isValid = false;
        }else if(person.getNamaDepan().equals(""))
        {
            list.add("Nama Tengah Tidak Boleh Kosong");isValid = false;
        }else if(person.getNamaDepan().matches("^\\s*$")){
            list.add("Nama Tengah Tidak Boleh Blank");isValid = false;
        }
        if(person.getNamaBelakang()==null)
        {
            list.add("Nama Belakang Tidak Boleh Null");isValid = false;
        }else if(person.getNamaDepan().equals(""))
        {
            list.add("Nama Belakang Tidak Boleh Kosong");isValid = false;
        }else if(person.getNamaDepan().matches("^\\s*$")){
            list.add("Nama Belakang Tidak Boleh Blank");isValid = false;
        }

        if(person.getNamaDepan().length()<6 && person.getNamaDepan().length()>26 )
        {
            list.add("Nama Depan Minimal 5 Maksimal 25 Karakter");isValid = false;
        }
        if(person.getNamaTengah().length()<6 && person.getNamaTengah().length()>26 )
        {
            list.add("Nama Tengah Minimal 5 Maksimal 25 Karakter");isValid = false;
        }
        if(person.getNamaBelakang().length()<6 && person.getNamaBelakang().length()>26 )
        {
            list.add("Nama Depan Minimal 5 Maksimal 25 Karakter");isValid = false;
        }
    }
}