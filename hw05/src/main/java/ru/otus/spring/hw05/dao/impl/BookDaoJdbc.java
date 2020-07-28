package ru.otus.spring.hw05.dao.impl;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.spring.hw05.dao.BookDao;
import ru.otus.spring.hw05.domain.Author;
import ru.otus.spring.hw05.domain.Book;
import ru.otus.spring.hw05.domain.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class BookDaoJdbc implements BookDao {

    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    public BookDaoJdbc(NamedParameterJdbcOperations namedParameterJdbcOperations) {
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
    }

    @Override
    public void insert(Book book) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", book.getId());
        params.put("title", book.getTitle());
        namedParameterJdbcOperations.update(
                "insert into books (id, title) " +
                        "values (:id, :title)",
                params
        );
    }

    @Override
    public void update(Book book) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", book.getId());
        params.put("title", book.getTitle());
        namedParameterJdbcOperations.update(
                "update books SET " +
                        "title = :title" +
                        " WHERE id = :id",
                params);
    }

    @Override
    public Book getById(Long id) {
        final Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        Book book = namedParameterJdbcOperations.queryForObject(
                "select " +
                        "b.id as book_id," +
                        "b.title as book_title," +
                        "a.id as author_id," +
                        "a.name as author_name," +
                        "g.id as genre_id," +
                        "g.description as genre_description," +
                        "from books as b " +
                        "left join authors as a on b.author_id = a.id " +
                        "left join genres as g on b.genre_id = g.id " +
                        "where b.id = :id",
                params, new BookMapper());
        return book;
    }

    @Override
    public List<Book> getAll() {
        return namedParameterJdbcOperations.query(
                "select " +
                        "b.id as book_id," +
                        "b.title as book_title," +
                        "a.id as author_id," +
                        "a.name as author_name," +
                        "g.id as genre_id," +
                        "g.description as genre_description," +
                        "from books as b " +
                        "left join authors as a on b.author_id = a.id " +
                        "left join genres as g on b.genre_id = g.id",
                new BookMapper());
    }

    @Override
    public void delete(Long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        namedParameterJdbcOperations.update(
                "delete from books where id = :id", params
        );
    }

    @Override
    public void addGenreToBook(Long bookId, Long genreId) {
        Map<String, Object> params = new HashMap<>();
        params.put("book_id", bookId);
        params.put("genre_id", genreId);
        namedParameterJdbcOperations.update(
                "update books set genre_id = :genre_id where id = :book_id",
                params
        );
    }

    @Override
    public void addAuthorToBook(Long bookId, Long authorId) {
        Map<String, Object> params = new HashMap<>();
        params.put("book_id", bookId);
        params.put("author_id", authorId);
        namedParameterJdbcOperations.update(
                "update books set author_id = :author_id where id = :book_id",
                params
        );
    }

    private static class BookMapper implements RowMapper<Book> {
        @Override
        public Book mapRow(ResultSet resultSet, int i) throws SQLException {
            long bookId = resultSet.getLong("book_id");
            String bookTitle = resultSet.getString("book_title");
            long authorId = resultSet.getLong("author_id");
            String authorName = resultSet.getString("author_name");
            long genreId = resultSet.getLong("genre_id");
            String genreDescription = resultSet.getString("genre_description");

            return new Book(bookId, bookTitle, new Author(authorId, authorName), new Genre(genreId, genreDescription));
        }
    }
}
