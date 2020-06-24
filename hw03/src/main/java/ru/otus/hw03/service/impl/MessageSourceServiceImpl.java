package ru.otus.hw03.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.hw03.configs.Properties;
import ru.otus.hw03.service.MessageSourceService;

import java.util.Locale;
import java.util.ResourceBundle;

@Service
@RequiredArgsConstructor
public class MessageSourceServiceImpl implements MessageSourceService {

    private final Properties properties;

    @Override
    public String getMessage(String key) {
        ResourceBundle bundle = ResourceBundle.getBundle(properties.getBundlePath(), new Locale(properties.getLocale()));
        return bundle.getString(key);
    }
}
