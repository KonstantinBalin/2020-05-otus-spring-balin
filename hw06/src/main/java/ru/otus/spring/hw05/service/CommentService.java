package ru.otus.spring.hw05.service;

import ru.otus.spring.hw05.domain.Comment;

import java.util.List;

public interface CommentService {
    void add(Comment comment);
    void update(Long id, String comment);
    Comment getById(long id);
    List<Comment> getAll();
    void delete(long id);
}
