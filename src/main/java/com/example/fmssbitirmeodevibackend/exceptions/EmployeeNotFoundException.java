package com.example.fmssbitirmeodevibackend.exceptions;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(String message){
        super(message);
    }

    public EmployeeNotFoundException(){
        super("Employee not found !");
    }
}
