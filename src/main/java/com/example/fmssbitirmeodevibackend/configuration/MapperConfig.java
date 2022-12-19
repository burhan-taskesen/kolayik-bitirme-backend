package com.example.fmssbitirmeodevibackend.configuration;

import com.example.fmssbitirmeodevibackend.mapper.mymapper.MyMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public MyMapper myMapper(){
        return new MyMapper();
    }
}
