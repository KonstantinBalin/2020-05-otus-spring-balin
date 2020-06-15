package ru.otus.hw02.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.otus.hw02.Runner;
import ru.otus.hw02.domain.TestItem;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { Runner.class })
@DisplayName("Test QuestionAnswerRepositoryCsv")
public class QuestionAnswerRepositoryCsvTest {

    @Autowired
    private QARepository repository;

    @DisplayName("корректно создаётся конструктором")
    @Test
    void shouldHaveCorrectSize() throws Exception {
        Set<TestItem> questions = repository.getQuestions();
        assertEquals(3, questions.size());
    }
}
