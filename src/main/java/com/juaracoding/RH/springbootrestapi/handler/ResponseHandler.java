package com.juaracoding.RH.springbootrestapi.handler;/*
IntelliJ IDEA 2022.3.1 (Community Edition)
Build #IC-223.8214.52, built on December 20, 2022
@Author Rhay Riswan Hadiyanto
Java Developer
Created on 03/08/2023 21:36
@Last Modified 03/08/2023 21:36
Version 1.0
*/

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    public ResponseHandler() {
    }

    public ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj, Object errorCode, WebRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("status", status.value());
        map.put("data", responseObj==null?"":responseObj);
        map.put("timestamp", new Date());
        map.put("success",!status.isError());
        if(errorCode != null)
        {
            map.put("errorCode",errorCode);
            map.put("path",request.getDescription(false));
        }
        return new ResponseEntity<Object>(map,status);
    }

    public Map<String,Object> generateModelAttribut(String message, HttpStatus status, Object responseObj, Object errorCode, WebRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("status", status.value());
        map.put("data", responseObj==null?"":responseObj);
        map.put("timestamp", new Date());
        map.put("success",!status.isError());
        if(errorCode != null)
        {
            map.put("errorCode",errorCode);
            map.put("path",request.getDescription(false));
        }
        return map;
    }
}