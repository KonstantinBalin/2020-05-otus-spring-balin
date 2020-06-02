package ru.otus.hw01.service.impl;


import ru.otus.hw01.domain.Item;
import ru.otus.hw01.repository.QuestionAnswerRepository;
import ru.otus.hw01.service.QuestionAnswerService;

import java.util.Set;

public class QuestionAnswerServiceImpl implements QuestionAnswerService {

    private QuestionAnswerRepository repository;

    public QuestionAnswerServiceImpl(QuestionAnswerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Set<Item> getQuestions() throws Exception {
        return repository.getQuestions();
    }
}
