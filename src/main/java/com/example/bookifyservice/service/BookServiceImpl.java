package com.example.bookifyservice.service;

import com.example.bookifyservice.exception.BookNotFoundException;
import com.example.bookifyservice.model.dao.BookDAO;
import com.example.bookifyservice.model.dto.SearchBookDTO;
import com.example.bookifyservice.repository.BookRepository;
import com.example.bookifyservice.util.Utils;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class BookServiceImpl implements BookService{

    BookRepository bookRepository;

    @Override
    public BookDAO getBook(String id) {
        Optional<BookDAO> bookDAO = bookRepository.findById(id);
        if(!bookDAO.isPresent()){
            throwNotFound(id);
        }
        return bookDAO.get();
    }

    @Override
    public BookDAO createBook(BookDAO bookDAO) {
        bookDAO.setCreatedDate(Utils.getTimestamp());
        return bookRepository.save(bookDAO);
    }

    @Override
    public BookDAO updateBook(String id, BookDAO bookDAO) {
        doesBookExist(id);
        bookDAO.setId(id);
        return bookRepository.save(bookDAO);
    }

    @Override
    public void deleteBook(String id) {
        doesBookExist(id);
        bookRepository.deleteById(id);
    }

    @Override
    public Page<BookDAO> searchBooks(SearchBookDTO searchBookDTO, Pageable pageable) {
        ExampleMatcher customExampleMatcher = ExampleMatcher.matchingAll()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("author", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("genre", ExampleMatcher.GenericPropertyMatchers.exact());
        return bookRepository.findAll(Example.of(searchBookDTO.toBookDAO(), customExampleMatcher), pageable);
    }

    private void doesBookExist(String id) {
        if(!bookRepository.existsById(id)){
            throwNotFound(id);
        }
    }

    private boolean throwNotFound(String id) {
        throw new BookNotFoundException("Book with Id : " + id + " not found.");
    }
}
