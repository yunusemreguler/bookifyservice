package com.example.bookifyservice.controller;

import com.example.bookifyservice.exception.BookAlreadyExistException;
import com.example.bookifyservice.exception.BookNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    public ResponseEntity<?> handleBookNotFoundException(BookNotFoundException ex){
        log.info("[handleBookNotFoundException] Book not found, Message = {}", ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    @ResponseBody
    public ResponseEntity<?> handleBookAlreadyExistException(BookAlreadyExistException ex){
        log.info("[handleBookAlreadyExistException] Book already exists, Message = {}", ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

}
