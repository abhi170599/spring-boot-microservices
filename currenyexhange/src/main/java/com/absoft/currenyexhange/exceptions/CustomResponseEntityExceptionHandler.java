package com.absoft.currenyexhange.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleGenericExceptions(Exception ex, WebRequest request){
        ExceptionModel exceptionModel = new ExceptionModel(ex.getMessage(),new Date(),request.getDescription(false));
        return new ResponseEntity<>(exceptionModel,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<Object> handleNotFoundExceptions(NotFoundException ex, WebRequest request) {
        ExceptionModel exceptionModel = new ExceptionModel(ex.getMessage(),new Date(),request.getDescription(false));
        return new ResponseEntity<>(exceptionModel,HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExceptionModel exceptionModel = new ExceptionModel(ex.getMessage(), new Date(),
                request.getDescription(false));
            return new ResponseEntity<>(exceptionModel, HttpStatus.BAD_REQUEST);            
    }
    
}
