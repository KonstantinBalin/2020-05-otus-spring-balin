package ru.otus.hw02.controller.impl;


import org.springframework.stereotype.Controller;
import ru.otus.hw02.controller.QAController;
import ru.otus.hw02.domain.TestItem;
import ru.otus.hw02.domain.TestResult;
import ru.otus.hw02.domain.User;
import ru.otus.hw02.exceptions.QAControllerException;
import ru.otus.hw02.service.IOService;
import ru.otus.hw02.service.QAService;
import ru.otus.hw02.service.UserService;

import java.util.Set;

@Controller
public class QAControllerImpl implements QAController {

    private final QAService questionAnswerService;
    private final IOService ioService;
    private final UserService userService;

    public QAControllerImpl(
            QAService questionAnswerService,
            IOService ioService,
            UserService userService) {
        this.questionAnswerService = questionAnswerService;
        this.ioService = ioService;
        this.userService = userService;
    }

    @Override
    public void startTest() throws QAControllerException {
        try {
            Set<TestItem> items = questionAnswerService.getQuestions();
            User user = userService.getUserInfo();
            TestResult result = questionAnswerService.startTest(user, items);
            ioService.write(result.toString());
        } catch (Exception e) {
            throw new QAControllerException("method startTest() run with exception", e);
        }
    }
}
