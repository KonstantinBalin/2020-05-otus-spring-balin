package ru.otus.spring.hw06.service;

import ru.otus.spring.hw06.domain.Genre;
import java.util.List;
import java.util.Optional;

public interface GenreService {
    void add(Genre genre);
    void update(Genre genre);
    Optional<Genre> getById(long id);
    List<Genre> getAll();
    void delete(long id);
}
