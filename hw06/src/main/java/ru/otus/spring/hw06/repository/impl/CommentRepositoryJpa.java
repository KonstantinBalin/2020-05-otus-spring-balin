package ru.otus.spring.hw06.repository.impl;

import org.springframework.stereotype.Repository;
import ru.otus.spring.hw06.domain.Comment;
import ru.otus.spring.hw06.repository.CommentRepository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class CommentRepositoryJpa implements CommentRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Comment save(Comment comment) {
        if (comment.getId() == null) {
            em.persist(comment);
            return comment;
        } else {
            return em.merge(comment);
        }
    }

    @Override
    public void updateCommentById(long id, String text) {
        Query query = em.createQuery("update Comment c set c.text = :text where c.id = :id");
        query.setParameter("text", text);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public Optional<Comment> findById(long id) {
        return Optional.ofNullable(em.find(Comment.class, id));
    }

    @Override
    public List<Comment> findAll() {
        TypedQuery<Comment> query = em.createQuery("select c from Comment c ", Comment.class);
        return query.getResultList();
    }

    @Override
    public List<Comment> findByBookId(long bookId) {
        TypedQuery<Comment> query = em.createQuery("select c from Comment c where c.book.id = :id", Comment.class);
        query.setParameter("id", bookId);
        return query.getResultList();
    }

    @Override
    public void deleteById(Long id) {
        Query query = em.createQuery("delete from Comment c where c.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
