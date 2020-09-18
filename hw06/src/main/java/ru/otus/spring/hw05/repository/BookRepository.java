package ru.otus.spring.hw05.repository;

import ru.otus.spring.hw05.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    Book save(Book genre);
    void updateTitleById(long id, String title);
    Optional<Book> findById(long id);
    List<Book> findAll();
    void deleteById(Long id);
}
