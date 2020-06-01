package ru.otus.hw01.repository;

import ru.otus.hw01.domain.Item;

import java.util.Set;

public interface QuestionAnsverRepository {
    Set<Item> getQuestions() throws Exception;
}
