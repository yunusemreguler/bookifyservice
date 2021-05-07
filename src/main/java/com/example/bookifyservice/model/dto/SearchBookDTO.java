package com.example.bookifyservice.model.dto;

import com.example.bookifyservice.model.dao.BookDAO;
import com.example.bookifyservice.model.domain.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchBookDTO {

    @Size(min = 1, max = 100, message = "Book name length must be between 1 and 100!")
    private String name;
    @Size(min = 1, max = 100, message = "Author name length must be between 1 and 100!")
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
