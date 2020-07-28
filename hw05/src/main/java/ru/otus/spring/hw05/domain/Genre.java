package ru.otus.spring.hw05.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class Genre {
    private Long id;
    @NonNull
    private String description;

    public Genre(String description) {
        this.description = description;
    }
}
