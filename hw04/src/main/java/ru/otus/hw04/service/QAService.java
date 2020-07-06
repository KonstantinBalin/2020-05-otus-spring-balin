package ru.otus.hw04.service;

import ru.otus.hw04.domain.TestResult;
import ru.otus.hw04.domain.User;
import ru.otus.hw04.exceptions.QAServiceException;

public interface QAService {
    TestResult startTest(User user) throws QAServiceException;
}

