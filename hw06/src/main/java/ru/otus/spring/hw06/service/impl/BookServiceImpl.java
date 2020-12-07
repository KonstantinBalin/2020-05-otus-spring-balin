package ru.otus.spring.hw06.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.hw06.domain.Book;
import ru.otus.spring.hw06.repository.AuthorRepository;
import ru.otus.spring.hw06.repository.BookRepository;
import ru.otus.spring.hw06.repository.GenreRepository;
import ru.otus.spring.hw06.service.BookService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;

    @Transactional
    @Override
    public void add(Book book) {
        authorRepository.findById(book.getAuthor().getId()).ifPresent(book::setAuthor);
        genreRepository.findById(book.getGenre().getId()).ifPresent(book::setGenre);
        bookRepository.save(book);
    }

    @Transactional
    @Override
    public void update(Book book) {
        bookRepository.save(book);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Book> getById(long id) {
        return bookRepository.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Transactional
    @Override
    public void delete(long id) {
        bookRepository.deleteById(id);
    }
}
