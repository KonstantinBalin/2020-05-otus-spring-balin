package ru.otus.hw04.service;

public interface MessageSourceService {
    String getMessage(String key);
    String getMessage(String key, Object... args);
}
