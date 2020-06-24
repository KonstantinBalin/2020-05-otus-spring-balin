package ru.otus.hw03.exceptions;

public class QARepositoryException extends Exception{
    public QARepositoryException() {
        super();
    }

    public QARepositoryException(String message) {
        super(message);
    }

    public QARepositoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public QARepositoryException(Throwable cause) {
        super(cause);
    }

    protected QARepositoryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
