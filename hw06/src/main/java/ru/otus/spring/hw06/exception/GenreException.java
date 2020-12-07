package ru.otus.spring.hw06.exception;

public class GenreException extends RuntimeException {
    public GenreException() {
        super();
    }

    public GenreException(String message) {
        super(message);
    }

    public GenreException(String message, Throwable cause) {
        super(message, cause);
    }

    public GenreException(Throwable cause) {
        super(cause);
    }

    protected GenreException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
