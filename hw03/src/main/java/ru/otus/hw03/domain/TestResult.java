package ru.otus.hw03.domain;

import lombok.Data;

@Data
public class TestResult {
    private User user;
    private int allAnswerCount;
    private int successAnswerCount;
}
