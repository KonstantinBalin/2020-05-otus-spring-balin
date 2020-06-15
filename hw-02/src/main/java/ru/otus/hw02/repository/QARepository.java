package ru.otus.hw02.repository;

import ru.otus.hw02.domain.TestItem;
import ru.otus.hw02.exceptions.QARepositoryException;

import java.util.Set;

public interface QARepository {
    Set<TestItem> getQuestions() throws QARepositoryException;
}
