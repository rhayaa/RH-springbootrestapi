package com.juaracoding.RH.springbootrestapi.util;/*
IntelliJ IDEA 2022.3.1 (Community Edition)
Build #IC-223.8214.52, built on December 20, 2022
@Author Rhay Riswan Hadiyanto
Java Developer
Created on 02/08/2023 20:48
@Last Modified 02/08/2023 20:48
Version 1.0
*/

public class ConstantMessage {

    public final static String REGEX_DATE_YYYYMMDD = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$";
    public final static String REGEX_DATE_DDMMYY = "";
    /*
        REGISTER
     */
    public final static String REGIS_USRNAME_NOT_EMPTY = "Username tidak boleh kosong";
    public final static String REGIS_PWD_NOT_EMPTY = "Password tidak boleh kosong";
    public final static String REGIS_EMAIL_NOT_EMPTY = "Email tidak boleh kosong";
    public final static String REGIS_NO_HP_NOT_EMPTY = "No HP tidak boleh kosong";
    public final static String ERROR_UNEXPECTED = "UNEXPECTED ERROR";
    public final static String ERROR_UNPROCCESSABLE = "Validation error. Check 'errors' field for details.";
    public final static String ERROR_NO_CONTENT = "PERMINTAAN TIDAK DAPAT DIPROSES";
    public final static String ERROR_DATA_INVALID = "DATA TIDAK VALID";
    public final static String ERROR_INTERNAL_SERVER = "INTERNAL SERVER ERROR";
    public final static String ERROR_MAIL_FORM_JSON = "Malformed JSON request";
    public final static String SUCCESS_CREATED = "Data Berhasil Dibuat !";
    public final static String SUCCESS_UPDATED = "Data Berhasil Diubah !";
    public final static String SUCCESS_DELETE = "Data Berhasil Dihapus !";
    public final static String ERROR_FAILED_UPDATED = "Data Gagal Diubah !";
    public final static String ERROR_FAILED_CREATED = "Data Gagal Dibuat !";
    public final static String ERROR_DATA_NOT_FOUND = "Data Tidak Ditemukan!";


}
