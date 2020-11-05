package com.thoughtworks.capability.gtb.restfulapidesign.exception;

public class StudentAlreadyExistException extends RuntimeException {
    public StudentAlreadyExistException(String message){
        super(message);
    }

}
