package com.thoughtworks.capability.gtb.restfulapidesign.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentAlreadyExistException.class)
    public ResponseEntity<ErrorResult> handle(StudentAlreadyExistException ex) {
        ErrorResult errorResult = new ErrorResult(ex.getMessage(),400);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResult> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        ErrorResult errorResult = new ErrorResult( "用户名不合法",400);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorResult> handleConstraintViolationException(StudentNotFoundException ex){
        ErrorResult errorResult = new ErrorResult(ex.getMessage(),404);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }
    @ExceptionHandler(GenderErrorException.class)
    public ResponseEntity<ErrorResult> handlerGenderErrorException(GenderErrorException ex){
        ErrorResult errorResult = new ErrorResult(ex.getMessage(),404);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }
    @ExceptionHandler(GroupNotFoundException.class)
    public ResponseEntity<ErrorResult> handleGroupNotFoundException(GroupNotFoundException ex){
        ErrorResult errorResult = new ErrorResult(ex.getMessage(),404);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }


}
