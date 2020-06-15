package ru.otus.hw02.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.otus.hw02.exceptions.IOServiceException;
import ru.otus.hw02.service.IOService;
import java.io.*;

@Service
public class IOServiceImpl implements IOService {

    private  final InputStream input;
    private  final PrintStream output;

    public IOServiceImpl(@Qualifier("input") InputStream input, @Qualifier("output") PrintStream output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public String read() throws IOServiceException {
        try {
            return new BufferedReader(new InputStreamReader(input)).readLine();
        } catch (IOException e) {
            throw new IOServiceException("method read() exception");
        }
    }

    @Override
    public void write(String string)  {
        output.println(string);
    }
}
