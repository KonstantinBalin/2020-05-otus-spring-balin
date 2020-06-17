package ru.otus.hw02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.otus.hw02.controller.QAController;

@ComponentScan
@Configuration
public class Runner {
    public static void main(String[] args) throws Exception {
        ApplicationContext appContext = new AnnotationConfigApplicationContext(Runner.class);
        QAController controller = appContext.getBean(QAController.class);
        controller.startTest();
    }
}
