package ru.otus.hw04.exceptions;

public class QAServiceException extends Exception{
    public QAServiceException() {
        super();
    }

    public QAServiceException(String message) {
        super(message);
    }

    public QAServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public QAServiceException(Throwable cause) {
        super(cause);
    }

    protected QAServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
