package ru.otus.spring.hw05.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.spring.hw05.domain.Book;
import ru.otus.spring.hw05.service.BookService;

@ShellComponent
@RequiredArgsConstructor
public class BookCommands {

    private final BookService bookService;

    @ShellMethod(value = "Add book", key = {"addBook"})
    public void addBook(@ShellOption String title) {
        bookService.add(new Book(title));
    }

    @ShellMethod(value = "Update book", key = {"updateBook"})
    public void updateBook(@ShellOption Long id, @ShellOption String title) {
        bookService.update(new Book(id, title));
    }

    @ShellMethod(value = "Delete book", key = {"delBook"})
    public void deleteBook(@ShellOption Long id) {
        bookService.delete(id);
    }

    @ShellMethod(value = "Get book", key = {"getBook"})
    public void getBook(@ShellOption Long id) {
        System.out.println(bookService.getById(id));
    }

    @ShellMethod(value = "GetBookList", key = {"getBooks"})
    public void getBookList() {
        System.out.println(bookService.getAll());
    }

    @ShellMethod(value = "AddGenreToBook", key = {"addGenreToBook"})
    public void addGenreToBook(@ShellOption Long bookId, @ShellOption Long genreId) {
        bookService.addGenreToBook(bookId, genreId);
    }

    @ShellMethod(value = "AddAuthorToBook", key = {"addAuthorToBook"})
    public void addAuthorToBook(Long bookId, Long authorId) {
        bookService.addAuthorToBook(bookId, authorId);
    }
}
