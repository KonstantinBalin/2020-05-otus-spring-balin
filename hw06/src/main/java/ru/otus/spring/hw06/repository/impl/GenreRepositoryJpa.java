package ru.otus.spring.hw06.repository.impl;

import org.springframework.stereotype.Repository;
import ru.otus.spring.hw06.domain.Genre;
import ru.otus.spring.hw06.repository.GenreRepository;
import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Repository
public class GenreRepositoryJpa implements GenreRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Genre save(Genre genre) {
        if(genre.getId() == null) {
            em.persist(genre);
            return genre;
        } else {
            return em.merge(genre);
        }
    }

    @Override
    public void updateDescriptionById(long id, String description) {
        Query query = em.createQuery("update Genre g set g.description = :description where g.id = :id");
        query.setParameter("description", description);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public Optional<Genre> findById(long id) {
        return Optional.ofNullable(em.find(Genre.class, id));
    }

    @Override
    public List<Genre> findAll() {
        TypedQuery<Genre> query = em.createQuery("select g from Genre g", Genre.class);
        return query.getResultList();
    }

    @Override
    public void deleteById(Long id) {
        Query query = em.createQuery("delete from Genre g where g.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
