package com.example.demo.contoller.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class ControllerExceptionAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {IOException.class})
    public ResponseEntity<?> handleIOException(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, "Error occurred during file upload", new HttpHeaders(),
            HttpStatus.UNPROCESSABLE_ENTITY, request);
    }

    @ExceptionHandler(value = {IllegalArgumentException.class})
    public ResponseEntity<?> handleIllegalArgumentException(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, "Error occurred during file parsing", new HttpHeaders(),
            HttpStatus.UNPROCESSABLE_ENTITY, request);
    }

    @Override
    public ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        //TODO: write some logging here
        return super.handleNoHandlerFoundException(ex, headers, status, request);
    }

}
