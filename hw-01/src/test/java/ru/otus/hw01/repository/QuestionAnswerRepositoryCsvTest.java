package ru.otus.hw01.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.otus.hw01.domain.Item;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"/test-applicationContext.xml"})
@DisplayName("Test QuestionAnswerRepositoryCsv")
public class QuestionAnswerRepositoryCsvTest {

    @Autowired
    private QuestionAnswerRepository repository;

    @DisplayName("корректно создаётся конструктором")
    @Test
    void shouldHaveCorrectSize() throws Exception {
        Set<Item> questions = repository.getQuestions();
        assertEquals(3, questions.size());
    }
}
