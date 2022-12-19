package com.example.fmssbitirmeodevibackend.aspect.security;

import com.example.fmssbitirmeodevibackend.annotations.MyLengthAnnotation;
import com.example.fmssbitirmeodevibackend.exceptions.FieldLengthException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;

/**
 * Bu sınıf ile kendi tokenlarımı alıp verecektim, sonradan zamanın yetmiyeceğini
 * farkettiğim için vazgeçtim.
 */
@Aspect
@Slf4j
public class AspectValidation {
    @Around(value = "@annotation(com.example.fmssbitirmeodevibackend.annotations.MyLog)")
    public Object myLogFunction(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        try {
            System.err.println("    ---> " + proceedingJoinPoint.getArgs()[0].getClass().getSimpleName() + "");
        } catch (Exception e) {

        }

        log.debug(proceedingJoinPoint.getArgs().toString());

        return proceedingJoinPoint.proceed();
    }

    @Around(value = "@annotation(com.example.fmssbitirmeodevibackend.annotations.MyValidAnnotation)")
    public Object myValidFunction(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.debug(proceedingJoinPoint.getArgs().toString());

        //methodun tek bir parametresi olduğu varsayıldı. parametre listesinin içinde dönülmesi gerekiyor.
        Object object = proceedingJoinPoint.getArgs()[0];

        Arrays.stream(object.getClass().getDeclaredFields()).forEach(field -> {
            Arrays.stream(field.getAnnotations()).forEach(annotation -> {
                //Yeni versiyonlarda switch ile instanceof kullanımı daha hızlı hale gelebilir. Bu sayede
                //bu kodun hızı da artabilir.
                if (annotation instanceof MyLengthAnnotation) {
                    try {
                        int minLength = ((MyLengthAnnotation) annotation).min();
                        int maxLength = ((MyLengthAnnotation) annotation).max();
                        field.setAccessible(true);
                        String fieldValue = field.get(object).toString();
                        if (fieldValue.length() < minLength) {
                            throw new FieldLengthException(new StringBuilder("\"").append(field.getName()).append("\"").append(" özelliğinin uzunluğu en az ").append(minLength).append(" karakter olmalı").toString());
                        }
                        if (fieldValue.length() > maxLength) {
                            throw new FieldLengthException(new StringBuilder("\"").append(field.getName()).append("\"").append(" özelliğinin uzunluğu en fazla ").append(minLength).append(" karakter olmalı").toString());
                        }
                        field.setAccessible(false);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        });
        return proceedingJoinPoint.proceed();
    }
}
