package ru.otus.spring.hw06.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.spring.hw06.domain.Author;
import ru.otus.spring.hw06.service.AuthorService;

@ShellComponent
@RequiredArgsConstructor
public class AuthorCommands {

    private final AuthorService authorService;

    @ShellMethod(value = "Add author", key = {"addAuthor"})
    public void addAuthor(@ShellOption String name)  {
        Author author = new Author(null, name);
        authorService.add(author);
    }

    @ShellMethod(value = "Update author", key = {"updateAuthor"})
    public void  updateAuthor(@ShellOption long id, @ShellOption String name) {
        Author author = new Author(id, name);
        authorService.update(author);
    };

    @ShellMethod(value = "Delete author", key = {"delAuthor"})
    public void deleteAuthor(@ShellOption long id) {
        authorService.delete(id);
    };

    @ShellMethod(value = "Get author", key = {"getAuthor"})
    public void getAuthor(@ShellOption long id) {
        System.out.println(authorService.getById(id));
    };

    @ShellMethod(value = "Get author list", key = {"getAuthors"})
    public void getAuthorList() {
        System.out.println(authorService.getAll());
    }

}
