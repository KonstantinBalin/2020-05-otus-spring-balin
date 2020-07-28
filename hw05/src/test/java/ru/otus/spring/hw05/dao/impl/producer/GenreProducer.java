package ru.otus.spring.hw05.dao.impl.producer;

import org.springframework.boot.test.context.TestComponent;
import ru.otus.spring.hw05.domain.Genre;

@TestComponent
public class GenreProducer {
    public Genre getGenre() {
        return new Genre(1L, "Fantasy");
    }
}
