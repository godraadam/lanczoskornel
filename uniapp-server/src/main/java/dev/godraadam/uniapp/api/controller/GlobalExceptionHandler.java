package dev.godraadam.uniapp.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import dev.godraadam.uniapp.service.exception.EmailTakenException;
import dev.godraadam.uniapp.service.exception.IncorrectPasswordException;
import dev.godraadam.uniapp.service.exception.InvalidRegistrationTokenException;
import dev.godraadam.uniapp.service.exception.ResourceNotFoundException;
import dev.godraadam.uniapp.service.exception.UserNameTakenException;
import dev.godraadam.uniapp.service.exception.UserNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public void handleUserNotFound() {}

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(IncorrectPasswordException.class)
    public void handleIncorrectPassword() {}

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(UserNameTakenException.class)
    public void handleUsernameTaken() {}

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(EmailTakenException.class)
    public void handleEmailTaken() {}

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public void handleResourceNotFound() {}

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(InvalidRegistrationTokenException.class)
    public void handleInvalidToken() {}
    
}
