package com.company;

public class NoMoreThanOneWrapperException extends Exception{
    public NoMoreThanOneWrapperException() {}

    public NoMoreThanOneWrapperException(String message) {
        super(message);
    }
}