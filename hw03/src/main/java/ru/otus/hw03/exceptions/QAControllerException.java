package ru.otus.hw03.exceptions;

public class QAControllerException extends Exception{
    public QAControllerException() {
        super();
    }

    public QAControllerException(String message) {
        super(message);
    }

    public QAControllerException(String message, Throwable cause) {
        super(message, cause);
    }

    public QAControllerException(Throwable cause) {
        super(cause);
    }

    protected QAControllerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
