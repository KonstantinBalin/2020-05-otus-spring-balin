package ru.otus.hw04;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.hw04.domain.TestItem;
import ru.otus.hw04.repository.QARepository;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
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
