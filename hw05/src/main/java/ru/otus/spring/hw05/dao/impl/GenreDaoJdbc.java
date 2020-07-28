package ru.otus.spring.hw05.dao.impl;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.spring.hw05.dao.GenreDao;
import ru.otus.spring.hw05.domain.Genre;
import ru.otus.spring.hw05.exception.GenreException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class GenreDaoJdbc implements GenreDao {

    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    public GenreDaoJdbc(NamedParameterJdbcOperations namedParameterJdbcOperations) {
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
    }

    @Override
    public void insert(Genre genre) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", genre.getId());
        params.put("description", genre.getDescription());
        namedParameterJdbcOperations.update(
                "insert into genres (id, description) values (:id, :description)",
                params
        );
    }

    @Override
    public void update(Genre genre) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", genre.getId());
        params.put("description", genre.getDescription());

        namedParameterJdbcOperations.update(
                "update genres SET description = :description WHERE id = :id",
                params);
    }

    @Override
    public Genre getById(Long id) {
        final Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        try {
            return  namedParameterJdbcOperations.queryForObject(
                    "select * from genres where id = :id",
                    params, new GenreMapper());
        } catch (Exception e) {
            throw new GenreException("Genre not found", e);
        }
    }

    @Override
    public List<Genre> getAll() {
        return namedParameterJdbcOperations.query(
                "select * from genres",
                new GenreMapper());
    }

    @Override
    public void delete(Long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        namedParameterJdbcOperations.update(
                "delete from genres where id = :id", params
        );
    }

    private static class GenreMapper implements RowMapper<Genre> {
        @Override
        public Genre mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = resultSet.getLong("id");
            String description = resultSet.getString("description");
            return new Genre(id, description);
        }
    }
}
