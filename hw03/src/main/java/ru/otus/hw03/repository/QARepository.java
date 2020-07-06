package ru.otus.hw03.repository;

import ru.otus.hw03.domain.TestItem;
import ru.otus.hw03.exceptions.QARepositoryException;

import java.util.Set;

public interface QARepository {
    Set<TestItem> getQuestions() throws QARepositoryException;
}
