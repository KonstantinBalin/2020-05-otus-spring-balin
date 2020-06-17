package ru.otus.hw02.controller;

import ru.otus.hw02.exceptions.QAControllerException;

public interface QAController {
    void startTest() throws QAControllerException;
}

