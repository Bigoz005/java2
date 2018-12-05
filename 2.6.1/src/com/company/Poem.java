package com.company;

public class Poem extends Book {
    private String type;
    private String author;
    private String title;
    private int numberOfPages;

    public Poem(String type, String author, String title, int numberOfPages) {
        this.type = type;
        this.author = author;
        this.title = title;
        this.numberOfPages = numberOfPages;
    }

    @Override
    public String getBookType() {
        return this.type;
    }

    @Override
    public String getBookAuthor() {
        return this.author;
    }

    @Override
    public String getBookTitle() {
        return this.title;
    }

    @Override
    public int getNumberOfPages() {
        return this.numberOfPages;
    }
}