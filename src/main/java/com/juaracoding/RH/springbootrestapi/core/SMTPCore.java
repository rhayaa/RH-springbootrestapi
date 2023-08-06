package com.juaracoding.RH.springbootrestapi.core;/*
IntelliJ IDEA 2022.3.1 (Community Edition)
Build #IC-223.8214.52, built on December 20, 2022
@Author Rhay Riswan Hadiyanto
Java Developer
Created on 02/08/2023 20:30
@Last Modified 02/08/2023 20:30
Version 1.0
*/


import com.juaracoding.RH.springbootrestapi.configuration.ConfigSMTPConfiguration;
import com.juaracoding.RH.springbootrestapi.configuration.OtherConfig;
import com.juaracoding.RH.springbootrestapi.handler.ResourceNotFoundException;
import com.juaracoding.RH.springbootrestapi.util.LoggingFile;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;
import java.util.Properties;

public class SMTPCore {

    Properties prop ;
    private Message message ;
    private Session session;
    private String strDestination;
    private StringBuilder sBuild ;
    private MimeBodyPart messageBodyPart;
    private Multipart multipart;
    private String [] strException = new String[2];

    public SMTPCore()
    {
        sBuild = new StringBuilder();
        strException[0] = "SMTPCore";
    }



    private Properties getTLSProp()
    {
        prop = new Properties();
        prop.put("mail.smtp.host", ConfigSMTPConfiguration.getEmailHost());
        prop.put("mail.smtp.port", ConfigSMTPConfiguration.getEmailPortTLS());
        prop.put("mail.smtp.auth", ConfigSMTPConfiguration.getEmailAuth());
        prop.put("mail.smtp.starttls.enable", ConfigSMTPConfiguration.getEmailStartTLSEnable());

        return prop;
    }

    private Properties getSSLProp()
    {
        prop = new Properties();
        prop.put("mail.smtp.host", ConfigSMTPConfiguration.getEmailHost());
        prop.put("mail.smtp.port", ConfigSMTPConfiguration.getEmailPortSSL());
        prop.put("mail.smtp.auth", ConfigSMTPConfiguration.getEmailAuth());
        prop.put("mail.smtp.socketFactory.port", ConfigSMTPConfiguration.getEmailStartTLSEnable());
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        return prop;
    }

    public boolean sendSimpleMail(String[] strMailTo, String strSubject, String strContentMessage, String strLayer)  {
        Properties execProp ;
        try {

            if(strLayer.equals("SSL")) {
                execProp = getSSLProp();
            }
            else
            {
                execProp = getTLSProp();
            }

            sBuild.setLength(0);
            for(int i=0;i<strMailTo.length;i++)
            {
                sBuild.setLength(0);
                strDestination = sBuild.append(strMailTo[i]).toString();

                if(i != strMailTo.length-1)
                {
                    sBuild.setLength(0);
                    strDestination = sBuild.append(strDestination).append(",").toString();
                }

            }

            session = Session.getInstance(execProp,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(ConfigSMTPConfiguration.getEmailUserName(), ConfigSMTPConfiguration.getEmailPassword());
                        }
                    });

            message = new MimeMessage(session);
            message.setFrom(new InternetAddress(ConfigSMTPConfiguration.getEmailUserName()));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(strDestination)
            );
            message.setSentDate(new Date());

            /*BODY OF MAIL*/
            message.setSubject(strSubject);
            message.setText(strContentMessage);

            Transport.send(message);
            System.out.println("Done");

        } catch (Exception e) {
            strException[1]="sendSimpleMail(String[] strMailTo, String strSubject, String strContentMessage, String strLayer) -- LINE 107";
            LoggingFile.exceptionStringz(strException,e, OtherConfig.getFlagLogging());
            return false;
        }

        return true;
    }

    public boolean sendMailWithAttachment(String[] strMailTo,
                                          String strSubject,
                                          String strContentMessage,
                                          String strLayer, String[] attachFiles) throws ResourceNotFoundException {
        Properties execProp ;


        if(strLayer.equals("SSL")) {
            execProp = getSSLProp();
        }
        else
        {
            execProp = getTLSProp();
        }

        sBuild.setLength(0);
        for(int i=0;i<strMailTo.length;i++)
        {
            sBuild.setLength(0);
            strDestination = sBuild.append(strMailTo[i]).toString();

            if(i != strMailTo.length-1)
            {
                sBuild.setLength(0);
                strDestination = sBuild.append(strDestination).append(",").toString();
            }
        }
        session = Session.getInstance(execProp,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(ConfigSMTPConfiguration.getEmailUserName(), ConfigSMTPConfiguration.getEmailPassword());
                    }
                });


        try {
            message = new MimeMessage(session);
            message.setFrom(new InternetAddress(ConfigSMTPConfiguration.getEmailUserName()));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(strDestination)
            );
            message.setSentDate(new Date());
            message.setSubject(strSubject);

            // creates message part
            messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(strContentMessage, "text/html");

            // creates multi-part
            multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            // adds attachments
            if (attachFiles != null && attachFiles.length > 0) {
                for (String filePath : attachFiles) {
                    MimeBodyPart attachPart = new MimeBodyPart();

                    try {
                        attachPart.attachFile(filePath);
                    } catch (Exception ex) {
                        throw new Exception(ex.getMessage());
                    }
                    multipart.addBodyPart(attachPart);
                }
            }

            // sets the multi-part as e-mail's content
            message.setContent(multipart);

            // sends the e-mail
            Transport.send(message);

        } catch (Exception e) {
            strException[1]="sendMailWithAttachment(String[] strMailTo, String strSubject, String strContentMessage, String strLayer, String[] attachFiles) -- LINE 107";
            LoggingFile.exceptionStringz(strException,e, OtherConfig.getFlagLogging());
            return false;
        }

        return true;
    }
}
