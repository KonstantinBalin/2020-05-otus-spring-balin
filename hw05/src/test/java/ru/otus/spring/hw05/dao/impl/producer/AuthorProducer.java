package ru.otus.spring.hw05.dao.impl.producer;

import org.springframework.boot.test.context.TestComponent;
import ru.otus.spring.hw05.domain.Author;

@TestComponent
public class AuthorProducer {
    public Author getAuthor() {
        return new Author(1L, "Konstantin Balin");
    }
}
