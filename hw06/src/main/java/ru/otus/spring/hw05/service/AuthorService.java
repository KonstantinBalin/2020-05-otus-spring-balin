package ru.otus.spring.hw05.service;

import ru.otus.spring.hw05.domain.Author;
import java.util.List;

public interface AuthorService {
    void add(Author author);
    void update(Author author);
    Author getById(long id);
    List<Author> getAll();
    void delete(long id);
}
