package ru.otus.hw04.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.hw04.service.IOMessageSourceService;
import ru.otus.hw04.service.IOService;
import ru.otus.hw04.service.MessageSourceService;

@Service
@RequiredArgsConstructor
public class IOMessageSourceServiceImpl implements IOMessageSourceService {

    private final IOService ioService;
    private final MessageSourceService mss;

    @Override
    public void write(String key) {
        ioService.write(mss.getMessage(key));
    }

    @Override
    public void write(String key, Object... args) {
        ioService.write(mss.getMessage(key, args));
    }
}
