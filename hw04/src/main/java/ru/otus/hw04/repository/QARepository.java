package ru.otus.hw04.repository;

import ru.otus.hw04.domain.TestItem;
import ru.otus.hw04.exceptions.QARepositoryException;

import java.util.Set;

public interface QARepository {
    Set<TestItem> getQuestions() throws QARepositoryException;
}
