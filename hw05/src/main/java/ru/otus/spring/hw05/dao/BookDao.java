package ru.otus.spring.hw05.dao;

import ru.otus.spring.hw05.domain.Book;

import java.util.List;

public interface BookDao {
    void insert(Book book);
    void update(Book book);
    Book getById(Long id);
    List<Book> getAll();
    void delete(Long id);
    void addGenreToBook(Long bookId, Long genreId);
    void addAuthorToBook(Long bookId, Long genreId);
}
