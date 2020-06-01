package ru.otus.hw01.service;

import ru.otus.hw01.domain.Item;

import java.util.Set;

public interface QuestionAnswerService {
    Set<Item> getQuestions() throws Exception;
}

