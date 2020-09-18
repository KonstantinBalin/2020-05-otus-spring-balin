package ru.otus.spring.hw05.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring.hw05.dao.GenreDao;
import ru.otus.spring.hw05.domain.Genre;
import ru.otus.spring.hw05.service.GenreService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreDao dao;

    @Override
    public void add(Genre genre) {
        dao.insert(genre);
    }

    @Override
    public void update(Genre genre) {
        dao.update(genre);
    }

    @Override
    public Genre getById(long id) {
        return dao.getById(id);
    }

    @Override
    public List<Genre> getAll() {
        return dao.getAll();
    }

    @Override
    public void delete(long id) {
        dao.delete(id);
    }
}
