package ru.otus.spring.hw05.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class Author {
    private Long id;
    @NonNull
    private String name;

    public Author(String name) {
        this.name = name;
    }
}
