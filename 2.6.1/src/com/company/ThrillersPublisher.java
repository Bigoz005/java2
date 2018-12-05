package com.company;

public class ThrillersPublisher implements Publisher {
    private String type;
    private String author;

    public ThrillersPublisher(String author) {
        this.type = "Thriller";
        this.author = author;
    }

    @Override
    public Thriller createBook(String title, int numberOfPages) {
        return new Thriller(type, author, title, numberOfPages);
    }
}