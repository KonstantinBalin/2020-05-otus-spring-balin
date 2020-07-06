package ru.otus.hw03.service;

import ru.otus.hw03.domain.TestResult;
import ru.otus.hw03.domain.User;
import ru.otus.hw03.exceptions.QAServiceException;

public interface QAService {
    TestResult startTest(User user) throws QAServiceException;
}

