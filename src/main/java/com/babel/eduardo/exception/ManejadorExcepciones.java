package com.babel.eduardo.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "com.babel.eduardo.controller")
public class ManejadorExcepciones {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
	Map<String, String> errors = new HashMap<>();
	ex.getBindingResult().getAllErrors().forEach(error -> {
	    String fieldName = error instanceof FieldError ? ((FieldError) error).getField() : error.getObjectName();
	    String errorMessage = error.getDefaultMessage();
	    errors.put(fieldName, errorMessage);
	});
	return errors;
    }
}