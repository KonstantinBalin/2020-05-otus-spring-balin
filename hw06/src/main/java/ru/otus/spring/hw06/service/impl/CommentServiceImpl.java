package ru.otus.spring.hw06.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.hw06.domain.Comment;
import ru.otus.spring.hw06.repository.BookRepository;
import ru.otus.spring.hw06.repository.CommentRepository;
import ru.otus.spring.hw06.service.CommentService;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final BookRepository bookRepository;

    @Transactional
    @Override
    public void add(Comment comment, Long bookId) {
        bookRepository.findById(bookId).ifPresent(comment::setBook);
        commentRepository.save(comment);
    }

    @Transactional
    @Override
    public void update(Long id, String comment) {
        commentRepository.updateCommentById(id, comment);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Comment> getById(long id) {
        return commentRepository.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Comment> getAll() {
        return commentRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Comment> getByBookId(long bookId) {
        return commentRepository.findByBookId(bookId);
    }

    @Transactional
    @Override
    public void delete(long id) {
        commentRepository.deleteById(id);
    }
}
