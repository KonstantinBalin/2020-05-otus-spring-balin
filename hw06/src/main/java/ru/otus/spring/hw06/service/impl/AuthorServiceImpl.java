package ru.otus.spring.hw06.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.hw06.repository.AuthorRepository;
import ru.otus.spring.hw06.service.AuthorService;
import ru.otus.spring.hw06.domain.Author;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository repository;

    @Transactional
    @Override
    public void add(Author author) {
        repository.save(author);
    }

    @Transactional
    @Override
    public void update(Author author) {
        repository.save(author);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Author> getById(long id) {
        return repository.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Author> getAll() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}
