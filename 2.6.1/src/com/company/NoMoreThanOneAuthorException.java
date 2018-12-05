package com.company;

public class NoMoreThanOneAuthorException extends Exception {
    public NoMoreThanOneAuthorException() {}

    public NoMoreThanOneAuthorException(String message) {
        super(message);
    }
}