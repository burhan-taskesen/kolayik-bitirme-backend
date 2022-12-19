package com.example.fmssbitirmeodevibackend;

import com.example.fmssbitirmeodevibackend.annotations.MyValidAnnotation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileObject;
import java.time.ZonedDateTime;
import java.util.Set;

@SpringBootApplication
@EnableAspectJAutoProxy
public class FmssBitirmeOdeviBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(FmssBitirmeOdeviBackendApplication.class, args);
    }

}
