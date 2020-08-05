package ru.otus.spring.hw05.dao.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.otus.spring.hw05.dao.GenreDao;
import ru.otus.spring.hw05.domain.Genre;
import ru.otus.spring.hw05.exception.GenreException;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Dao for work with genres")
@JdbcTest
@Import({GenreDaoJdbc.class})
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class GenreDaoJdbcTest {

    @Autowired
    private GenreDao genreDao;

    @Test
    @DisplayName("Add new genre")
    void insert() {
        Genre genre = new Genre(null, "Test genre");
        int genreCountBeforeInsert = genreDao.getAll().size();
        genreDao.insert(genre);
        int genreCountAfterInsert = genreDao.getAll().size();
        assertThat(genreCountBeforeInsert, lessThan(genreCountAfterInsert));
    }

    @Test
    void update() {
        genreDao.update(new Genre(1L, "Adventure"));
        Genre genreFromDao = genreDao.getById(1L);
        assertThat(genreFromDao, allOf(
                hasProperty("id", is(1L)),
                hasProperty("description", is("Adventure"))
        ));
    }

    @Test
    void getById() {
        Genre genre = genreDao.getById(1L);
        assertThat(genre, notNullValue());
    }

    @Test
    void getAll() {
        List<Genre> genres = genreDao.getAll();
        assertThat(genres.size(), is(2));
    }

    @Test
    void delete() {
        List<Genre> genres = genreDao.getAll();
        genreDao.delete(2L);
        Exception exception = assertThrows(GenreException.class, () -> {
            genreDao.getById(2L);
        });
        String expectedMessage = "Genre not found";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}