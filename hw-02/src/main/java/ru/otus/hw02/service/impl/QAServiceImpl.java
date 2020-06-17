package ru.otus.hw02.service.impl;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import ru.otus.hw02.domain.TestItem;
import ru.otus.hw02.domain.TestResult;
import ru.otus.hw02.domain.User;
import ru.otus.hw02.exceptions.IOServiceException;
import ru.otus.hw02.exceptions.QARepositoryException;
import ru.otus.hw02.exceptions.QAServiceException;
import ru.otus.hw02.repository.QARepository;
import ru.otus.hw02.service.IOService;
import ru.otus.hw02.service.QAService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@PropertySource("classpath:application.properties")
public class QAServiceImpl implements QAService {

    final private QARepository repository;
    final private IOService ioService;

    public QAServiceImpl(QARepository repository, IOService ioService) {
        this.repository = repository;
        this.ioService = ioService;
    }

    @Override
    public Set<TestItem> getQuestions() throws QAServiceException {
        try {
            return repository.getQuestions();
        } catch (QARepositoryException e) {
            throw new QAServiceException("method getQuestions run with exception", e);
        }
    }

    @Override
    public TestResult startTest(User user, Set<TestItem> items) throws QAServiceException {
        try {

            TestResult result = new TestResult();
            result.setUser(user);
            result.setAllAnswerCount(items.size());
            ioService.write("You need to answer " + items.size() + " questions.\n");
            int successUserAnswer = 0;

            for (TestItem item : items) {
                List<Integer> correctAnswersForTestItem = getCorrectAnswerNumbers(item);
                askUser(item, correctAnswersForTestItem.size());
                List<Integer> userAnswersForTestItem = getUserAnswersForTestItem();

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

    private List<Integer> getUserAnswersForTestItem() throws IOServiceException {
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
                ioService.write("choose the correct answer options");
                ioService.write(Character.toString((char) 9711) + "  " + (i + 1) + " " + item.getAnswers().get(i).getAnswer());
            } else {
                ioService.write("choose the " + correctAnswerCount + " correct answer options separated by commas");
                ioService.write(Character.toString((char) 9744) + "  " + (i + 1) + " " + item.getAnswers().get(i).getAnswer());
            }
        }
    }
}

