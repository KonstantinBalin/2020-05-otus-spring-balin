package ru.otus.hw01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.hw01.controller.QuestionAnswerController;

public class Run {
    public static void main(String[] args) throws Exception {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        QuestionAnswerController controller = (QuestionAnswerController) appContext.getBean("questionAnswerController");
        controller.startTest();
    }
}
