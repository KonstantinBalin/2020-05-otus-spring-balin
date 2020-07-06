package ru.otus.hw04.service;

public interface IOMessageSourceService {
    void write(String key);
    void write(String key, Object... args);
}
