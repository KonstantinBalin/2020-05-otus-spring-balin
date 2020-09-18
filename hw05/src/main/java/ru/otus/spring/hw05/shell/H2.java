package ru.otus.spring.hw05.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.h2.tools.Console;
import java.sql.SQLException;

@ShellComponent
public class H2 {

    @ShellMethod(value = "Run h2 console", key = {"runH2"})
    public void runH2Console() throws SQLException {
        Console.main();
    }

}
