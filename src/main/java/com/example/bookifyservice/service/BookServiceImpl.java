package com.example.bookifyservice.service;

import com.example.bookifyservice.exception.BookNotFoundException;
import com.example.bookifyservice.model.dao.BookDAO;
import com.example.bookifyservice.repository.BookRepository;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class BookServiceImpl implements BookService{

    BookRepository bookRepository;

    @Override
    public BookDAO getBook(String bookId) {
        Optional<BookDAO> bookDAO = bookRepository.findById(bookId);
        if(!bookDAO.isPresent()){
            throw new BookNotFoundException("Book with Id : " + bookId + " not found.");
        }
        return bookDAO.get();
    }

    @Override
    public BookDAO createBook(BookDAO bookDAO) {
        bookRepository.save(bookDAO);
        return bookDAO;
    }
}
