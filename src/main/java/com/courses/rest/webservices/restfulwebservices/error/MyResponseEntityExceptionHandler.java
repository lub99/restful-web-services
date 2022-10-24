package com.courses.rest.webservices.restfulwebservices.error;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class MyResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorExplanationToUser> handleUserNotFoundException(Exception ex, WebRequest request) {
        ErrorExplanationToUser errorExplanationToUser = new ErrorExplanationToUser(ex.getMessage(), "Typed non existing user id!");
        return new ResponseEntity<>(errorExplanationToUser, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ErrorExplanationToUser errorExplanationToUser = new ErrorExplanationToUser(ex.getFieldError().getDefaultMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorExplanationToUser, HttpStatus.BAD_REQUEST);
    }
}
