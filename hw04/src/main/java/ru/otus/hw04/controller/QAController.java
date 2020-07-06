package ru.otus.hw04.controller;

import ru.otus.hw04.exceptions.QAControllerException;

public interface QAController {
    void startTest() throws QAControllerException;
}

