package ru.otus.hw02.service;

import ru.otus.hw02.domain.TestItem;
import ru.otus.hw02.domain.TestResult;
import ru.otus.hw02.domain.User;
import ru.otus.hw02.exceptions.QAServiceException;

import java.util.Set;

public interface QAService {
    Set<TestItem> getQuestions() throws QAServiceException;
    TestResult startTest(User user, Set<TestItem> items) throws QAServiceException;
}

