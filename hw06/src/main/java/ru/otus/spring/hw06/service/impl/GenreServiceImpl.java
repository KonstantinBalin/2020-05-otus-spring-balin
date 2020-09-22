package ru.otus.spring.hw06.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.hw06.domain.Genre;
import ru.otus.spring.hw06.repository.GenreRepository;
import ru.otus.spring.hw06.service.GenreService;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository repository;

    @Transactional
    @Override
    public void add(Genre genre) {
        repository.save(genre);
    }

    @Transactional
    @Override
    public void update(Genre genre) {
        repository.save(genre);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Genre> getById(long id) {
        return repository.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Genre> getAll() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}
