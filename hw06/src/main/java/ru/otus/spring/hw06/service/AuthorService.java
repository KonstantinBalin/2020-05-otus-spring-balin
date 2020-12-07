package ru.otus.spring.hw06.service;

import ru.otus.spring.hw06.domain.Author;
import java.util.List;
import java.util.Optional;

public interface AuthorService {
    void add(Author author);
    void update(Author author);
    Optional<Author> getById(long id);
    List<Author> getAll();
    void delete(long id);
}
