package com.example.bookifyservice.model.dto;

import com.example.bookifyservice.model.dao.BookDAO;
import com.example.bookifyservice.model.domain.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchBookDTO {

    private String name;
    private String author;
    private Genre genre;

    public BookDAO toBookDAO(){
        BookDAO bookDAO = new BookDAO();
        bookDAO.setName(this.name);
        bookDAO.setAuthor(this.author);
        bookDAO.setGenre(this.genre);
        return bookDAO;
    }

}
