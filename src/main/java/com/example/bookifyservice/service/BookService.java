package com.example.bookifyservice.service;

import com.example.bookifyservice.model.dao.BookDAO;
import com.example.bookifyservice.model.dto.SearchBookDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {

    BookDAO getBook(String bookId);

    BookDAO createBook(BookDAO bookDAO);

    BookDAO updateBook(String id, BookDAO bookDAO);

    void deleteBook(String id);

    Page<BookDAO> searchBooks(SearchBookDTO searchBookDTO, Pageable pageable);

}
