package ru.otus.spring.hw06.service;

import ru.otus.spring.hw06.domain.Comment;
import java.util.List;
import java.util.Optional;

public interface CommentService {
    void add(Comment comment, Long bookId);
    void update(Long id, String comment);
    Optional<Comment> getById(long id);
    List<Comment> getAll();
    List<Comment> getByBookId(long bookId);
    void delete(long id);
}
