package com.example.bookifyservice.repository;

import com.example.bookifyservice.model.dao.BookDAO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<BookDAO, String> {

    boolean existsByName(String name);

}
