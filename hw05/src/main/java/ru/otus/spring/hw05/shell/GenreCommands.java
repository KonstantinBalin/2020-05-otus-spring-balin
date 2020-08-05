package ru.otus.spring.hw05.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.spring.hw05.domain.Genre;
import ru.otus.spring.hw05.service.GenreService;

@ShellComponent
@RequiredArgsConstructor
public class GenreCommands {

    private final GenreService genreService;

    @ShellMethod(value = "Add genre", key = {"addGenre"})
    public void addGenre(@ShellOption String description) {
        genreService.add(new Genre(null, description));
    }

    @ShellMethod(value = "Update genre", key = {"updateGenre"})
    public void updateGenre(@ShellOption long id, @ShellOption String description) {
        genreService.update(new Genre(id, description));
    }

    @ShellMethod(value = "Delete genre", key = {"delGenre"})
    public void deleteGenre(@ShellOption long id) {
        genreService.delete(id);
    }

    @ShellMethod(value = "Get genre", key = {"getGenre"})
    public void getGenre(@ShellOption long id) {
        System.out.println(genreService.getById(id).toString());
    }
    @ShellMethod(value = "Get genre list", key = {"getGenres"})
    public void getGenreList() {
        System.out.println(genreService.getAll());
    }
}
