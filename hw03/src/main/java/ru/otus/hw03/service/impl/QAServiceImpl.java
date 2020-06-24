package ru.otus.hw03.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import ru.otus.hw03.domain.TestItem;
import ru.otus.hw03.domain.TestResult;
import ru.otus.hw03.domain.User;
import ru.otus.hw03.exceptions.IOServiceException;
import ru.otus.hw03.exceptions.QARepositoryException;
import ru.otus.hw03.exceptions.QAServiceException;
import ru.otus.hw03.repository.QARepository;
import ru.otus.hw03.service.IOService;
import ru.otus.hw03.service.MessageSourceService;
import ru.otus.hw03.service.QAService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service

@RequiredArgsConstructor
public class QAServiceImpl implements QAService {

    private final QARepository repository;
    private final IOService ioService;
    private final MessageSourceService ms;

    @Override
    public TestResult startTest(User user) throws QAServiceException {
        try {
            Set<TestItem> items = getQuestions();
            TestResult result = new TestResult();
            result.setUser(user);
            result.setAllAnswerCount(items.size());
            ioService.write(String.format(ms.getMessage("text.start-test"),items.size()));
            int successUserAnswer = 0;

            for (TestItem item : items) {
                List<Integer> correctAnswersForTestItem = getCorrectAnswerNumbers(item);
                askUser(item, correctAnswersForTestItem.size());


                List<Integer> userAnswersForTestItem = null;
                while (userAnswersForTestItem == null) {
                    try {
                        userAnswersForTestItem = getUserAnswersForTestItem();
                    } catch (Exception e) {
                        ioService.write(ms.getMessage("text.incorrect-answer-entered"));
                    }
                }

                if (correctAnswersForTestItem.equals(userAnswersForTestItem)) {
                    successUserAnswer++;
                }
            }
            result.setSuccessAnswerCount(successUserAnswer);
            return result;
        } catch (Exception e) {
            throw new QAServiceException("methos startTest() run with exception", e);
        }
    }

    private Set<TestItem> getQuestions() throws QAServiceException {
        try {
            return repository.getQuestions();
        } catch (QARepositoryException e) {
            throw new QAServiceException("method getQuestions run with exception", e);
        }
    }

    private List<Integer> getUserAnswersForTestItem() {
        return Arrays.asList(ioService.read().strip().split(","))
                .stream()
                .map(Integer::parseInt).collect(Collectors.toList());
    }

    private List<Integer> getCorrectAnswerNumbers(TestItem item) {
        List<Integer> correctAnswersForTestItem = new ArrayList<>();
        for (int i = 0; i < item.getAnswers().size(); i++) {
            if (item.getAnswers().get(i).isCorrect()) {
                correctAnswersForTestItem.add(i + 1);
            }
        }
        return correctAnswersForTestItem;
    }

    private void askUser(TestItem item, long correctAnswerCount) {
        ioService.write(item.getQuestion());
        for (int i = 0; i < item.getAnswers().size(); i++) {
            if (correctAnswerCount == 1) {
                ioService.write(ms.getMessage("test.choose"));
                ioService.write(Character.toString((char) 9711) + "  " + (i + 1) + " " + item.getAnswers().get(i).getAnswer());
            } else {
                ioService.write(String.format(ms.getMessage("test.multi-choice"),correctAnswerCount));
                ioService.write(Character.toString((char) 9744) + "  " + (i + 1) + " " + item.getAnswers().get(i).getAnswer());
            }
        }
    }
}

