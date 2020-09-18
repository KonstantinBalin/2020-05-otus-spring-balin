package ru.otus.spring.hw05.dao.impl;

import lombok.val;
import org.assertj.core.api.Assertions;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import ru.otus.spring.hw05.domain.Book;
import ru.otus.spring.hw05.repository.BookRepository;
import ru.otus.spring.hw05.repository.impl.BookRepositoryJpa;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Тест репозиториев на основе JPA")
@DataJpaTest
@Import(BookRepositoryJpa.class)
class GenreDaoJdbcTest {

    private static final Long FIRST_BOOK_ID = 1L;
    private static final int EXPECTED_NUMBER_OF_BOOKS = 2;
    private static final int EXPECTED_QUERIES_COUNT = 1;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private TestEntityManager em;

    @DisplayName("должен загружать информацию о нужной книге по ее id")
    @Test
    void shouldFindExpectedBookById() {
        val optionalActualStudent = bookRepository.findById(FIRST_BOOK_ID);
        val expectedStudent = em.find(Book.class, FIRST_BOOK_ID);
        Assertions.assertThat(optionalActualStudent).isPresent().get()
                .isEqualToComparingFieldByField(expectedStudent);
    }

    @DisplayName("должен загружать список всех книг с полной информацией о них")
    @Test
    void shouldReturnCorrectBooksListWithAllInfo() {
        SessionFactory sessionFactory = em.getEntityManager().getEntityManagerFactory()
                .unwrap(SessionFactory.class);
        sessionFactory.getStatistics().setStatisticsEnabled(true);


        System.out.println("\n\n\n\n----------------------------------------------------------------------------------------------------------");
        val books = bookRepository.findAll();
        assertThat(books).isNotNull().hasSize(EXPECTED_NUMBER_OF_BOOKS)
                .allMatch(b -> !b.getAuthor().equals(""))
                .allMatch(b -> b.getGenre() != null)
                .allMatch(b -> b.getComments().size() > 0);
        System.out.println("----------------------------------------------------------------------------------------------------------\n\n\n\n");
        assertThat(sessionFactory.getStatistics().getPrepareStatementCount()).isEqualTo(EXPECTED_QUERIES_COUNT);
    }
}