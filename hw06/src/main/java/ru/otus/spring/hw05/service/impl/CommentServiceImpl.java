package ru.otus.spring.hw05.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.hw05.domain.Comment;
import ru.otus.spring.hw05.repository.CommentRepository;
import ru.otus.spring.hw05.service.CommentService;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository  repository;

    @Transactional
    @Override
    public void add(Comment comment) {
        repository.save(comment);
    }

    @Transactional
    @Override
    public void update(Long id, String comment) {
        repository.updateCommentById(id, comment);
    }

    @Transactional(readOnly = true)
    @Override
    public Comment getById(long id) {
        return repository.findById(id).get();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Comment> getAll() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}
