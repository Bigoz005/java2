package com.company;

public class NoMoreThanOneCover extends Exception{
    public NoMoreThanOneCover() {}

    public NoMoreThanOneCover(String message) {
        super(message);
    }
}