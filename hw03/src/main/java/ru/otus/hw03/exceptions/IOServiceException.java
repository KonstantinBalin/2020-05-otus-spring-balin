package ru.otus.hw03.exceptions;

public class IOServiceException extends Exception{
    public IOServiceException() {
        super();
    }

    public IOServiceException(String message) {
        super(message);
    }

    public IOServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public IOServiceException(Throwable cause) {
        super(cause);
    }

    protected IOServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
