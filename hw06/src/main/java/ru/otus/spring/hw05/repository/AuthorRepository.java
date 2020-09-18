package ru.otus.spring.hw05.repository;

import ru.otus.spring.hw05.domain.Author;
import ru.otus.spring.hw05.domain.Genre;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository {
    Author save(Author author);
    void updateNameById(long id, String name);
    Optional<Author> findById(long id);
    List<Author> findAll();
    void deleteById(Long id);
}
