package ru.otus.spring.hw05.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.hw05.domain.Author;
import ru.otus.spring.hw05.domain.Book;
import ru.otus.spring.hw05.domain.Genre;
import ru.otus.spring.hw05.repository.AuthorRepository;
import ru.otus.spring.hw05.repository.BookRepository;
import ru.otus.spring.hw05.repository.GenreRepository;
import ru.otus.spring.hw05.service.BookService;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;

    @Transactional
    @Override
    public void add(Book book) {
        Author author = authorRepository.findById(book.getAuthor().getId()).get();
        Genre genre = genreRepository.findById(book.getGenre().getId()).get();
        book.setAuthor(author);
        book.setGenre(genre);
        bookRepository.save(book);
    }

    @Transactional
    @Override
    public void update(Book book) {
        bookRepository.save(book);
    }

    @Transactional(readOnly = true)
    @Override
    public Book getById(long id) {
        return bookRepository.findById(id).get();
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
