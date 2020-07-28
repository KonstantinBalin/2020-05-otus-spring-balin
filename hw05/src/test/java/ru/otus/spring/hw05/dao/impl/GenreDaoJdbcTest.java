package ru.otus.spring.hw05.dao.impl;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.otus.spring.hw05.dao.GenreDao;
import ru.otus.spring.hw05.dao.impl.producer.GenreProducer;
import ru.otus.spring.hw05.domain.Genre;
import ru.otus.spring.hw05.exception.GenreException;
import java.util.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Dao for work with genres")
@JdbcTest
@Import({GenreDaoJdbc.class, GenreProducer.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GenreDaoJdbcTest {

    @Autowired
    private GenreProducer genreProducer;

    @Autowired
    private GenreDao genreDao;

    @BeforeAll
    public void before() {
        Genre genre = genreProducer.getGenre();
        genreDao.insert(genre);
    }

    @Test
    @DisplayName("Add new genre")
    void insert() {
        Genre genre = genreProducer.getGenre();

        Optional<Genre> genreFromDao = genreDao.getAll().stream()
                .filter(g -> g.getDescription().equals(genre.getDescription()))
                .findFirst();

        assertThat(genreFromDao.isPresent(), is(true));
        assertThat(genreFromDao.get(), allOf(
                hasProperty("id", notNullValue()),
                hasProperty("description", is("Fantasy"))
        ));
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
        assertThat(genres.size(), is(1));
    }

    @Test
    void delete() {
        genreDao.delete(1L);
        Exception exception = assertThrows(GenreException.class, () -> {
            genreDao.getById(1L);
        });
        String expectedMessage = "Genre not found";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}