package ru.otus.hw03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.otus.hw03.controller.QAController;

@SpringBootApplication
public class Runner {

    public static void main(String[] args) throws Exception {
        ApplicationContext appContext = SpringApplication.run(Runner.class, args);
        QAController controller = appContext.getBean(QAController.class);
        controller.startTest();
    }

}
