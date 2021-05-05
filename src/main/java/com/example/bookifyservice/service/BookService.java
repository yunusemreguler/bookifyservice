package com.example.bookifyservice.service;

import com.example.bookifyservice.exception.BookNotFoundException;
import com.example.bookifyservice.model.dao.BookDAO;

public interface BookService {

    BookDAO getBook(String bookId);

    BookDAO createBook(BookDAO bookDAO);

    BookDAO updateBook(String id, BookDAO bookDAO);

    void deleteBook(String id);

}
