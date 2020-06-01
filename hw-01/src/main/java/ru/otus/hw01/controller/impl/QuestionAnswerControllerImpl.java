package ru.otus.hw01.controller.impl;

import ru.otus.hw01.controller.QuestionAnswerController;
import ru.otus.hw01.domain.Item;
import ru.otus.hw01.service.QuestionAnswerService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;

public class QuestionAnswerControllerImpl implements QuestionAnswerController {

    private QuestionAnswerService questionAnswerService;

    public QuestionAnswerControllerImpl(QuestionAnswerService questionAnswerService) {
        this.questionAnswerService = questionAnswerService;
    }

    @Override
    public void startTest() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<Item> items = questionAnswerService.getQuestions();

        System.out.println("What is your last name?");
        String lastName = reader.readLine();
        System.out.println("What is your name?");
        String firstName = reader.readLine();
        System.out.printf("You need to answer %d questions.\n", items.size());


        for (Item item : items) {
            System.out.println(item.getQuestion());
            for (int i = 0; i < item.getAnswers().size(); i++) {
                System.out.println(i + 1 + " " + item.getAnswers().get(i).getAnswer());
            }
            System.out.println();
        }

    }
}
