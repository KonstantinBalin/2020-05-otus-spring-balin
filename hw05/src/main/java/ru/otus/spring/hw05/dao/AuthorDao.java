package ru.otus.spring.hw05.dao;

import ru.otus.spring.hw05.domain.Author;

import java.util.List;

public interface AuthorDao {
    void insert(Author author);
    void update(Author author);
    Author getById(Long id);
    List<Author> getAll();
    void delete(Long id);
}
