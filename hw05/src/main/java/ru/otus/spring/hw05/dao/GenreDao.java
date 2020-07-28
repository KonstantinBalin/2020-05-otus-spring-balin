package ru.otus.spring.hw05.dao;

import ru.otus.spring.hw05.domain.Author;
import ru.otus.spring.hw05.domain.Genre;

import java.util.List;

public interface GenreDao {
    void insert(Genre genre);
    void update(Genre genre);
    Genre getById(Long id);
    List<Genre> getAll();
    void delete(Long id);
}
