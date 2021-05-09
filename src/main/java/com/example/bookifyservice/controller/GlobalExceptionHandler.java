package com.example.bookifyservice.controller;

import com.example.bookifyservice.exception.BookAlreadyExistException;
import com.example.bookifyservice.exception.BookNotFoundException;
import com.example.bookifyservice.model.domain.ApiExceptionResponse;
import com.example.bookifyservice.util.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    @ResponseBody
    public ResponseEntity<?> handleBookNotFoundException(BookNotFoundException ex, HttpServletRequest req){
        log.info("[handleBookNotFoundException] Book not found, Message = {}", ex.getMessage());
        return new ResponseEntity<>(getApiExceptionResponse(HttpStatus.NOT_FOUND, ex.getMessage(), req.getServletPath()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BookAlreadyExistException.class)
    @ResponseBody
    public ResponseEntity<?> handleBookAlreadyExistException(BookAlreadyExistException ex, HttpServletRequest req){
        log.info("[handleBookAlreadyExistException] Book already exists, Message = {}", ex.getMessage());
        return new ResponseEntity<>(getApiExceptionResponse(HttpStatus.CONFLICT, ex.getMessage(), req.getServletPath()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest req){
        log.info("[handleMethodArgumentNotValidException] Bad request, Message = {}", ex.getMessage());
        ApiExceptionResponse response = getApiExceptionResponse(HttpStatus.BAD_REQUEST, ex.getBindingResult().getFieldError().getDefaultMessage(), req.getServletPath());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public ResponseEntity<?> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex, HttpServletRequest req){
        log.info("[HttpMessageNotReadableException] Bad request, Message = {}", ex.getMessage());
        return new ResponseEntity<>(getApiExceptionResponse(HttpStatus.BAD_REQUEST, "Invalid enum!", req.getServletPath()), HttpStatus.BAD_REQUEST);
    }

    private ApiExceptionResponse getApiExceptionResponse(HttpStatus httpStatus, String message, String path){
        ApiExceptionResponse response = new ApiExceptionResponse();
        response.setError(httpStatus.toString());
        response.setTimestamp(Utils.getDateTime());
        response.setStatus(httpStatus.value());
        response.setMessage(message);
        response.setPath(path);
        return response;
    }

}
