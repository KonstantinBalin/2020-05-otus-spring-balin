package ru.otus.hw02.service;

import ru.otus.hw02.domain.User;
import ru.otus.hw02.exceptions.IOServiceException;
import ru.otus.hw02.exceptions.UserServiceException;

public interface UserService {
    User getUserInfo() throws IOServiceException, UserServiceException;
}
