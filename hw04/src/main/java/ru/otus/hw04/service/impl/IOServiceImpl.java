package ru.otus.hw04.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.otus.hw04.service.IOService;
import java.io.*;
import java.util.Scanner;

@Service
@Primary
public class IOServiceImpl implements IOService {

    private final InputStream input;
    private final PrintStream output;

    public IOServiceImpl(@Value("#{ T(java.lang.System).in}") InputStream input,
                         @Value("#{ T(java.lang.System).out}") PrintStream output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public String read() {
        Scanner scanner = new Scanner(input);
        return scanner.nextLine();
    }

    @Override
    public void write(String string) {
        output.println(string);
    }
}
