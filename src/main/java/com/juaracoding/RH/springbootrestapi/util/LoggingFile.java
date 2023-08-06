package com.juaracoding.RH.springbootrestapi.util;/*
IntelliJ IDEA 2022.3.1 (Community Edition)
Build #IC-223.8214.52, built on December 20, 2022
@Author Rhay Riswan Hadiyanto
Java Developer
Created on 02/08/2023 20:36
@Last Modified 02/08/2023 20:36
Version 1.0
*/
import org.apache.log4j.Logger;
public class LoggingFile {

    private static StringBuilder sbuilds = new StringBuilder();
    private static Logger logger = Logger.getLogger(LoggingFile.class);
    public static void exceptionStringz(String[] datax,Exception e, String flag) {
        if(flag.equals("y"))
        {
            sbuilds.setLength(0);
            logger.info(sbuilds.append(System.getProperty("line.separator")).
                    append("ERROR IN CLASS =>").append(datax[0]).append(System.getProperty("line.separator")).
                    append("METHOD   =>").append(datax[1]).append(System.getProperty("line.separator")).
                    append("ERROR IS       =>").append(e.getMessage()).
                    append(System.getProperty("line.separator")).toString());
            sbuilds.setLength(0);
        }
    }

    public static void exceptionStringz(String[] datax,Exception e, String flag,String addNotes) {
        if(flag.equals("y"))
        {
            sbuilds.setLength(0);
            logger.info(sbuilds.append(System.getProperty("line.separator")).
                    append("ERROR IN CLASS =>").append(datax[0]).append(System.getProperty("line.separator")).
                    append("METHOD   =>").append(datax[1]).append(System.getProperty("line.separator")).
                    append("ERROR IS       =>").append(e.getMessage()).
                    append("Notes Tambahan       =>").append(addNotes).
                    append(System.getProperty("line.separator")).toString());
            sbuilds.setLength(0);
        }
    }

}
