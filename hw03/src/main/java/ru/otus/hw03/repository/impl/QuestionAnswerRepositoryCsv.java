package ru.otus.hw03.repository.impl;

import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import ru.otus.hw03.common.Type;
import ru.otus.hw03.configs.Properties;
import ru.otus.hw03.domain.Answer;
import ru.otus.hw03.domain.TestItem;
import ru.otus.hw03.exceptions.QARepositoryException;
import ru.otus.hw03.repository.QARepository;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static ru.otus.hw03.common.Type.valueOf;


@Repository
public class QuestionAnswerRepositoryCsv implements QARepository {

    private final Properties properties;

    public QuestionAnswerRepositoryCsv(Properties properties) {
        this.properties = properties;
    }

    public Set<TestItem> getQuestions() throws QARepositoryException {
        try {

            String questionAnswerFile = properties.getFileName();

            Map<Long, TestItem> items = new HashMap<>();

            CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(new ClassPathResource(questionAnswerFile).getFile())));

            String[] line;
            while (true) {

                if (!((line = reader.readNext()) != null)) break;

                checkCorrectSize(line);
                TestItem item = getItem(items, line[0]);

                if (line[1] != null) {
                    Type type = valueOf(line[1]);
                    switch (type) {
                        case SOLUTION:
                            checkAndSetSolutionToItem(line, item);
                            break;
                        case ANSWER:
                            checkAndSetAnswerToItem(line, item);
                            break;
                        case QUESTION:
                            checkAndSetQuestionToItem(line, item);
                            break;
                    }
                }


            }
            return new HashSet<>(items.values());
        } catch (Exception e) {
            throw new QARepositoryException("method getQuestions() run with exception", e);
        }
    }

    private TestItem getItem(Map<Long, TestItem> items, String s) {
        TestItem item;
        long id = Long.parseLong(s);

        if (items.containsKey(id)) {
            item = items.get(id);
        } else {
            item = new TestItem(id);
            items.put(id, item);
        }

        return item;
    }

    private void checkCorrectSize(String[] line) {
        if (line.length < 3) {
            throw new IllegalArgumentException("The row must contain at least 3 columns");
        }
    }

    private void checkAndSetSolutionToItem(String[] line, TestItem item) {
        if (line[2] != null) {
            item.setSolution(line[2]);
        }
    }

    private void checkAndSetQuestionToItem(String[] line, TestItem item) {
        if (line[2] != null) {
            item.setQuestion(line[2]);
        }
    }

    private void checkAndSetAnswerToItem(String[] line, TestItem item) {
        if (line[2] != null && line[3] != null) {
            Answer answer = new Answer();
            answer.setAnswer(line[2]);
            answer.setCorrect(Boolean.parseBoolean(line[3]));
            item.getAnswers().add(answer);
        }
    }
}
