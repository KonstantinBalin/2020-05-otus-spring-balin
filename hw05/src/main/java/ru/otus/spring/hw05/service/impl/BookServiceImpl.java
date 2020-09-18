package ru.otus.spring.hw05.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring.hw05.dao.AuthorDao;
import ru.otus.spring.hw05.dao.BookDao;
import ru.otus.spring.hw05.dao.GenreDao;
import ru.otus.spring.hw05.domain.Author;
import ru.otus.spring.hw05.domain.Book;
import ru.otus.spring.hw05.domain.Genre;
import ru.otus.spring.hw05.service.BookService;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookDao bookDao;
    private final AuthorDao authorDao;
    private final GenreDao genreDao;

    @Override
    public void add(Book book) {
        Author author = authorDao.getById(book.getAuthor().getId());
        Genre genre = genreDao.getById(book.getGenre().getId());
        book.setAuthor(author);
        book.setGenre(genre);
        bookDao.insert(book);
    }

    @Override
    public void update(Book book) {
        bookDao.update(book);
    }

    @Override
    public Book getById(long id) {
        return bookDao.getById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.getAll();
    }

    @Override
    public void delete(long id) {
        Book book = bookDao.getById(id);
        bookDao.delete(id);
    }
}
