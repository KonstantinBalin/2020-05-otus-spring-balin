package ru.otus.hw04.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.hw04.controller.QAController;
import ru.otus.hw04.exceptions.CommandException;

@ShellComponent
@RequiredArgsConstructor
public class Commands {

    @Autowired
    private final QAController controller;

    @ShellMethod(value = "Start test", key = {"s", "start-test"})
    public void startTest() throws CommandException {
        try {
            controller.startTest();
        } catch (Exception e) {
            throw new CommandException("Сommand execution error", e);
        }
    }
}
