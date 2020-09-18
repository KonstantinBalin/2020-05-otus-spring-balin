package ru.otus.spring.hw05.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring.hw05.service.AuthorService;
import ru.otus.spring.hw05.dao.AuthorDao;
import ru.otus.spring.hw05.domain.Author;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorDao dao;

    @Override
    public void add(Author author) {
        dao.insert(author);
    }

    @Override
    public void update(Author author) {
        dao.update(author);
    }

    @Override
    public Author getById(long id) {
        return dao.getById(id);
    }

    @Override
    public List<Author> getAll() {
        return dao.getAll();
    }

    @Override
    public void delete(long id) {
        dao.delete(id);
    }
}
