package com.nicotine.addiction.example.rest.driverRest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DriverRestExceptionHandler {

    // Add an exception handlers using @ExceptionHandler

    @ExceptionHandler
    public ResponseEntity<DriverErrorResponse> handleException(DriverNotFoundException exception) {

        DriverErrorResponse error = new DriverErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exception.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<DriverErrorResponse> handleException(Exception exception) {

        DriverErrorResponse error = new DriverErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exception.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
