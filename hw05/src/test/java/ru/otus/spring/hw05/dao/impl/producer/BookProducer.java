package ru.otus.spring.hw05.dao.impl.producer;

import org.springframework.boot.test.context.TestComponent;
import ru.otus.spring.hw05.domain.Book;

@TestComponent
public class BookProducer {
    public Book getBook() {
        return new Book(1L, "Book title", null, null);
    }
}
