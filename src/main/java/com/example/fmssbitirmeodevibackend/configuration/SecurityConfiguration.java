package com.example.fmssbitirmeodevibackend.configuration;

import com.example.fmssbitirmeodevibackend.aspect.security.AspectValidation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SecurityConfiguration {
    @Bean
    public AspectValidation mySecurity(){
        return new AspectValidation();
    }
}
