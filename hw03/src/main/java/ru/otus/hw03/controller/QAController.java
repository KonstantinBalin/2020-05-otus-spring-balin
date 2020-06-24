package ru.otus.hw03.controller;

import ru.otus.hw03.exceptions.QAControllerException;

public interface QAController {
    void startTest() throws QAControllerException;
}

