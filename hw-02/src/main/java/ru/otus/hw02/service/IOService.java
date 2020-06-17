package ru.otus.hw02.service;

import ru.otus.hw02.exceptions.IOServiceException;

public interface IOService {
    String read() throws IOServiceException;
    void write(String string);
}
