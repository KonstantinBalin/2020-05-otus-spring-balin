package ru.otus.hw02.configs;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;
import java.io.PrintStream;

@Configuration
public class Config {

    @Bean
    @Qualifier("input")
    public InputStream getInput() {
        return System.in;
    }

    @Bean
    @Qualifier("output")
    public PrintStream getOutput() {
        return System.out;
    }

}
