package com.example.bookifyservice.exception;

public class BookAlreadyExistException extends RuntimeException{

    public BookAlreadyExistException(String message){
        super(message);
    }
}
