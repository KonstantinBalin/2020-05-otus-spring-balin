package ru.otus.spring.hw06.repository;

import ru.otus.spring.hw06.domain.Comment;
import java.util.List;
import java.util.Optional;

public interface CommentRepository {
    Comment save(Comment comment);
    void updateCommentById(long id, String comment);
    Optional<Comment> findById(long id);
    List<Comment> findAll();
    List<Comment> findByBookId(long bookId);
    void deleteById(Long id);

}
