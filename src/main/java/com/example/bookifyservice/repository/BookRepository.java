package com.example.bookifyservice.repository;

import com.example.bookifyservice.model.dao.BookDAO;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BookRepository extends MongoRepository<BookDAO, String> {

    boolean existsByName(String name);

}
