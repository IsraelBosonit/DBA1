package com.example.DB1;

import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(com.example.DB1.NotFoundException.class)
    public final ResponseEntity<CustomError> NotFoundException(NotFoundException ex, WebRequest request) {
        CustomError customError = new CustomError(new Date(),HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity<CustomError>(customError, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(UnprocesableException.class)
    public final ResponseEntity<CustomError> UnprocessableException(UnprocesableException ex, WebRequest request) {
        CustomError customError = new CustomError(new Date(),HttpStatus.UNPROCESSABLE_ENTITY.value(), ex.getMessage());
        return new ResponseEntity<CustomError>(customError, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
