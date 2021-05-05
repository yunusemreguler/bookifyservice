package com.example.bookifyservice.controller;

import com.example.bookifyservice.model.dao.BookDAO;
import com.example.bookifyservice.service.BookService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/1.0/book")
@AllArgsConstructor
@Slf4j
public class BookController {

    BookService bookService;

    @GetMapping("/{id}")
    public ResponseEntity<BookDAO> getBook(@PathVariable("id") String bookId){
        log.info("[getBook] Get book request received, id = {}", bookId);
        return new ResponseEntity(bookService.getBook(bookId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BookDAO> createBook(@RequestBody BookDAO bookDAO){
        log.info("[createBook] Create book request received, request = {}", bookDAO);
        return new ResponseEntity(bookService.createBook(bookDAO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDAO> updateBook(@PathVariable("id") String bookId, @RequestBody BookDAO bookDAO){
        log.info("[updateBook] Update book request received, id = {}", bookId);
        return new ResponseEntity(bookService.updateBook(bookId, bookDAO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BookDAO> deleteBook(@PathVariable("id") String bookId){
        log.info("[deleteBook] Delete book request received, id = {}", bookId);
        bookService.deleteBook(bookId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
