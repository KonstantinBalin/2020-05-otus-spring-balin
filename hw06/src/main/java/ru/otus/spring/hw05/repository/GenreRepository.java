package ru.otus.spring.hw05.repository;

import ru.otus.spring.hw05.domain.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreRepository {
    Genre save(Genre genre);
    void updateDescriptionById(long id, String description);
    Optional<Genre> findById(long id);
    List<Genre> findAll();
    void deleteById(Long id);
}
