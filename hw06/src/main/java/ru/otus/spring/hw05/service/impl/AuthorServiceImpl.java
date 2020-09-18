package ru.otus.spring.hw05.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.hw05.repository.AuthorRepository;
import ru.otus.spring.hw05.service.AuthorService;
import ru.otus.spring.hw05.domain.Author;

import java.util.List;

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
    public Author getById(long id) {
        return repository.findById(id).get();
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
