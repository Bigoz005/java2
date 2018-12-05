package com.company;

public class PoemsPublisher implements Publisher {
    private String type;
    private String author;

    public PoemsPublisher(String author) {
        this.type = "Powieść";
        this.author = author;
    }

    @Override
    public Poem createBook(String title, int numberOfPages) {
        return new Poem(type, author, title, numberOfPages);
    }
}