package com.example.bookifyservice.controller;

import com.example.bookifyservice.model.dao.BookDAO;
import com.example.bookifyservice.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/1.0/book")
@AllArgsConstructor
public class BookController {

    BookService bookService;

    @GetMapping("/{id}")
    public ResponseEntity<BookDAO> getBook(@PathVariable("id") String bookId){
        return new ResponseEntity(bookService.getBook(bookId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BookDAO> createBook(@RequestBody BookDAO bookDAO){
        return new ResponseEntity(bookService.createBook(bookDAO), HttpStatus.CREATED);
    }

}
