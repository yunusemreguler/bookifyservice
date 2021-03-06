package com.example.bookifyservice.model.dao;

import com.example.bookifyservice.model.domain.Genre;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("books")
public class BookDAO {

    @Id
    @ReadOnlyProperty
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;
    @NotBlank(message = "Book name must not be blank!")
    @Size(min = 1, max = 100, message = "Book name length must be between 1 and 100!")
    private String name;
    @NotBlank(message = "Author name must not be blank!")
    @Size(min = 1, max = 100, message = "Author name length must be between 1 and 100!")
    private String author;
    private String description;
    private Genre genre;
    private String publisher;
    private Date publishDate;
    @ReadOnlyProperty
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long createdDate;

}
