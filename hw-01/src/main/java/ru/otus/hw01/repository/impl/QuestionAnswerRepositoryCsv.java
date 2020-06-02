package ru.otus.hw01.repository.impl;

import com.opencsv.CSVReader;
import org.springframework.core.io.Resource;
import ru.otus.hw01.common.Type;
import ru.otus.hw01.domain.Answer;
import ru.otus.hw01.domain.Item;
import ru.otus.hw01.repository.QuestionAnswerRepository;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static ru.otus.hw01.common.Type.valueOf;

public class QuestionAnswerRepositoryCsv implements QuestionAnswerRepository {
    private Resource file;

    public QuestionAnswerRepositoryCsv(Resource file) {
        this.file = file;
    }

    public Set<Item> getQuestions() throws Exception {
        Map<Long, Item> items = new HashMap<>();
        CSVReader reader = new CSVReader(new InputStreamReader(file.getInputStream()));

        String[] line;
        while ((line = reader.readNext()) != null) {
            checkCorrectSize(line);
            Item item = getItem(items, line[0]);

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
    }

    private Item getItem(Map<Long, Item> items, String s) {
        Item item;
        long id = Long.parseLong(s);

        if (items.containsKey(id)) {
            item = items.get(id);
        } else {
            item = new Item(id);
            items.put(id, item);
        }

        return item;
    }

    private void checkCorrectSize(String[] line) {
        if (line.length < 3) {
            throw new IllegalArgumentException("The row must contain at least 3 columns");
        }
    }

    private void checkAndSetSolutionToItem(String[] line, Item item) {
        if (line[2] != null) {
            item.setSolution(line[2]);
        }
    }

    private void checkAndSetQuestionToItem(String[] line, Item item) {
        if (line[2] != null) {
            item.setQuestion(line[2]);
        }
    }

    private void checkAndSetAnswerToItem(String[] line, Item item) {
        if (line[2] != null && line[3] != null) {
            Answer answer = new Answer();
            answer.setAnswer(line[2]);
            answer.setCorrect(Boolean.parseBoolean(line[3]));
            item.getAnswers().add(answer);
        }
    }
}
