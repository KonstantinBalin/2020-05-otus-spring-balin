package ru.otus.hw03.controller.impl;


import org.springframework.stereotype.Controller;
import ru.otus.hw03.controller.QAController;
import ru.otus.hw03.domain.TestItem;
import ru.otus.hw03.domain.TestResult;
import ru.otus.hw03.domain.User;
import ru.otus.hw03.exceptions.QAControllerException;
import ru.otus.hw03.service.IOService;
import ru.otus.hw03.service.MessageSourceService;
import ru.otus.hw03.service.QAService;
import ru.otus.hw03.service.UserService;

import java.util.Set;

@Controller
public class QAControllerImpl implements QAController {

    private final QAService questionAnswerService;
    private final IOService ioService;
    private final UserService userService;
    private final MessageSourceService mss;

    public QAControllerImpl(QAService questionAnswerService, IOService ioService, UserService userService, MessageSourceService mss) {
        this.questionAnswerService = questionAnswerService;
        this.ioService = ioService;
        this.userService = userService;
        this.mss = mss;
    }

    @Override
    public void startTest() throws QAControllerException {
        try {
            User user = userService.getUserInfo();
            TestResult testInfo = questionAnswerService.startTest(user);

            String result = String.format(
                    mss.getMessage("test.result"),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getAge(),
                    testInfo.getAllAnswerCount(),
                    testInfo.getSuccessAnswerCount());


            ioService.write(result);
        } catch (Exception e) {
            throw new QAControllerException("method startTest() run with exception", e);
        }
    }
}
