package ru.otus.hw02.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class Properties {
    private final  String fileName;


    public Properties(@Value("${filename}") String testFileName) {
        this.fileName = testFileName;
    }

    public String getFileName() {
        return fileName;
    }
}
