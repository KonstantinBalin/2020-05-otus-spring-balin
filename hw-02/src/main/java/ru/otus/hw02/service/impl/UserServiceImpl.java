package ru.otus.hw02.service.impl;

import org.springframework.stereotype.Service;
import ru.otus.hw02.domain.User;
import ru.otus.hw02.exceptions.IOServiceException;
import ru.otus.hw02.exceptions.UserServiceException;
import ru.otus.hw02.service.IOService;
import ru.otus.hw02.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final IOService ioService;

    public UserServiceImpl(IOService ioService) {
        this.ioService = ioService;
    }

    @Override
    public User getUserInfo() throws UserServiceException {
        User user = new User();
        try {
            ioService.write("What is your last name?");
            user.setLastName(ioService.read());
            ioService.write("What is your name?");
            user.setFirstName(ioService.read());
            ioService.write("How old are you?");
            user.setAge(Integer.parseInt(ioService.read()));
        } catch (IOServiceException e) {
            throw new UserServiceException("Cant read user information", e);
        }
        return user;
    }
}
