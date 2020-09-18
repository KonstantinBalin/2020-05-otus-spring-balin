package ru.otus.spring.hw05.repository;

import ru.otus.spring.hw05.domain.Comment;
import ru.otus.spring.hw05.domain.Genre;

import java.util.List;
import java.util.Optional;

public interface CommentRepository {
    Comment save(Comment comment);
    void updateCommentById(long id, String comment);
    Optional<Comment> findById(long id);
    List<Comment> findAll();
    void deleteById(Long id);

}
