package ru.otus.hw03.service;

public interface MessageSourceService {
    String getMessage(String key);
    String getMessage(String key, Object... args);
}
