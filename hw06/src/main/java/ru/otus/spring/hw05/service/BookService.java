package ru.otus.spring.hw05.service;


import ru.otus.spring.hw05.domain.Book;

import java.util.List;

public interface BookService {
    void add(Book book);
    void update(Book book);
    Book getById(long id);
    List<Book> getAll();
    void delete(long id);
}
