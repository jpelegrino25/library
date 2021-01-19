package com.julioluis.libraryapi.controllers;

import com.julioluis.libraryapi.models.ExceptionResponse;
import com.julioluis.libraryapi.utils.UserException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice
public class LibraryExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllLibraryException(Exception ex, WebRequest request) {

        ExceptionResponse responseDTO=new ExceptionResponse(new Date(),
                ex.getMessage(),request.getDescription(false));

        return new  ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(UserException.class)
    public  ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request) {

        ExceptionResponse responseDTO=new ExceptionResponse(new Date(),
                ex.getMessage(),request.getDescription(false));

        return new  ResponseEntity(responseDTO, HttpStatus.NOT_FOUND);

    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExceptionResponse responseDTO=new ExceptionResponse(new Date(),
                "Validation Failed",ex.getBindingResult().toString());

        return new  ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
    }

}
