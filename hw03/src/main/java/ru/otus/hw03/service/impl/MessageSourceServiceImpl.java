package ru.otus.hw03.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.hw03.configs.Properties;
import ru.otus.hw03.service.MessageSourceService;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class MessageSourceServiceImpl implements MessageSourceService {

    private final MessageSource ms;
    private final Properties properties;

    @Override
    public String getMessage(String key) {
        return getMessage(key, new Object[0], new Locale(properties.getLocale()));
    }

    @Override
    public String getMessage(String key, Object... args) {
        return  ms.getMessage(key, args, new Locale(properties.getLocale()));
    }
}