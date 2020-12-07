package ru.otus.spring.hw06.repository.impl;

import org.springframework.stereotype.Repository;
import ru.otus.spring.hw06.domain.Author;
import ru.otus.spring.hw06.repository.AuthorRepository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class AuthorRepositoryJpa implements AuthorRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Author save(Author author) {
        if(author.getId() == null) {
            em.persist(author);
            return author;
        } else {
            return em.merge(author);
        }
    }

    @Override
    public void updateNameById(long id, String name) {
        Query query = em.createQuery("update Author a set a.name = :name where a.id = :id");
        query.setParameter("name", name);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public Optional<Author> findById(long id) {
        return Optional.ofNullable(em.find(Author.class, id));
    }

    @Override
    public List<Author> findAll() {
        TypedQuery<Author> query = em.createQuery("select a from Author a ", Author.class);
        return query.getResultList();
    }

    @Override
    public void deleteById(Long id) {
        Query query = em.createQuery("delete from Author a where a.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
