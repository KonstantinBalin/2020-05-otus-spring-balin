package ru.otus.spring.hw05.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class Book {
    private Long id;
    @NonNull
    private String title;
    private Author author;
    private Genre genre;

    public Book(String title) {
        this.title = title;
    }

    public Book(Long id, String title) {
        this.id = id;
        this.title = title;
    }
}
