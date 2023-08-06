package com.juaracoding.RH.springbootrestapi.configuration;/*
IntelliJ IDEA 2022.3.1 (Community Edition)
Build #IC-223.8214.52, built on December 20, 2022
@Author Rhay Riswan Hadiyanto
Java Developer
Created on 03/08/2023 19:16
@Last Modified 03/08/2023 19:16
Version 1.0
*/


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2).
                select().
                apis(RequestHandlerSelectors.basePackage("com.juaracoding.RH.springbootrestapi.controller")).

                paths(PathSelectors.any()).build()
                .apiInfo(apiInfo());

    }

    //    ApiInfo(String title,
//    String description,
//    String version,
//    String termsOfServiceUrl,
//    String contactName,
//    String license,
//    String licenseUrl) {
    private ApiInfo apiInfo()
    {
        ApiInfo apiInfo = new ApiInfo(
                "Springboot+JPA+SQLServer",//title
                "Springboot bootcamp Juaracoding ",//descriptions
                "v1.0",//version
                "Term Of Services URL is On Progress",//termsOfServiceUrl
                new Contact("Riswan Hadi","localhost:8080","riswanhadi91@gmail.com"),//Contact Name
                "Springboot Open Source License",//license
                "https://spring.io/",//licenseUrl
                Collections.emptyList()
        );
        return apiInfo;
    }

}
