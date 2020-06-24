package ru.otus.hw03.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.hw03.domain.User;
import ru.otus.hw03.service.IOService;
import ru.otus.hw03.service.MessageSourceService;
import ru.otus.hw03.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final IOService ioService;
    private final MessageSourceService mss;

    @Override
    public User getUserInfo() {
        User user = new User();
        ioService.write(mss.getMessage("text.get-last-name"));
        user.setLastName(ioService.read());
        ioService.write(mss.getMessage("text.get-first-name"));
        user.setFirstName(ioService.read());
        ioService.write(mss.getMessage("text.get-age"));
        user.setAge(getInt());
        return user;
    }

    private int getInt() {
        int age = 0;
        while (age == 0 ) {
            try {
                age = Integer.parseInt(ioService.read());
            } catch (Exception e) {
                ioService.write(mss.getMessage("test.read-int-error-message"));
            }
        }
        return age;
    }
}
