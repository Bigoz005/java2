package com.company;

public class NoHardCoverException extends Exception {
    public NoHardCoverException() {}

    public NoHardCoverException(String message) {
        super(message);
    }
}