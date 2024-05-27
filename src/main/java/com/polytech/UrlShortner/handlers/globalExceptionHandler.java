package com.polytech.UrlShortner.handlers;

import com.polytech.UrlShortner.util.ErrorResponseUrl;
import com.polytech.UrlShortner.util.UrlEcxeption;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class globalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    private ResponseEntity<ErrorResponseUrl> handleInvalidUrlException(ConstraintViolationException e) {
        ErrorResponseUrl response = new ErrorResponseUrl(e.getConstraintViolations().stream().map(ConstraintViolation::getMessageTemplate)
                .collect(Collectors.joining(", ")), LocalDateTime.now());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UrlEcxeption.class)
    private ResponseEntity<ErrorResponseUrl> handleInvalidUrlException(UrlEcxeption e) {
        ErrorResponseUrl response = new ErrorResponseUrl(e.getMessage(),LocalDateTime.now());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }




}
