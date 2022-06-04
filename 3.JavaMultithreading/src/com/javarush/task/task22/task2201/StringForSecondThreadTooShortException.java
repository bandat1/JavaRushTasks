package com.javarush.task.task22.task2201;

public class StringForSecondThreadTooShortException extends RuntimeException {
    public StringForSecondThreadTooShortException(RuntimeException e) {
    }

    @Override
    public synchronized Throwable getCause() {
        return new StringIndexOutOfBoundsException("java.lang.StringIndexOutOfBoundsException: String index out of range: -1");
    }
}
