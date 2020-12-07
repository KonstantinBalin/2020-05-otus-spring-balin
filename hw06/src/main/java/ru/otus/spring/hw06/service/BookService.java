package ru.otus.spring.hw06.service;

import ru.otus.spring.hw06.domain.Book;
import java.util.List;
import java.util.Optional;

public interface BookService {
    void add(Book book);
    void update(Book book);
    Optional<Book> getById(long id);
    List<Book> getAll();
    void delete(long id);
}
