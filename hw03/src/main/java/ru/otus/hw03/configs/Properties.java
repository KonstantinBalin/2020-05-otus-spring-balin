package ru.otus.hw03.configs;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import javax.validation.constraints.NotBlank;

@Data
@Component
@ConfigurationProperties(prefix = "application-settings")
public class Properties {
    @NotBlank
    private String fileName;
    @NotBlank
    private  String locale;
    @NotBlank
    private  int correctAnswerCount;
    @NotBlank
    private  String bundlePath;
    @NotBlank
    private String encoding;

    public String getFileName() {
        return String.format(fileName, locale);
    }
}
