package ru.otus.spring.hw05.service;

import ru.otus.spring.hw05.domain.Genre;
import java.util.List;

public interface GenreService {
    void add(Genre genre);
    void update(Genre genre);
    Genre getById(long id);
    List<Genre> getAll();
    void delete(long id);
}
