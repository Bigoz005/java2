package com.company;

public class Book implements Publication {
    private String bookAuthor;
    private String bookTitle;
    private int numberOfPages;

    public Book(String bookAuthor, String bookTitle, int numberOfPages) {
        this.bookAuthor = bookAuthor;
        this.bookTitle = bookTitle;
        this.numberOfPages = numberOfPages;
    }

    @Override
    public String getBookAuthor() {
        return this.bookAuthor;
    }

    @Override
    public String getBookTitle() {
        return this.bookTitle;
    }

    @Override
    public int getNumberOfPages() {
        return this.numberOfPages;
    }

    @Override
    public String toString() {
        return "| " + getBookAuthor() + " | " + getBookTitle() + " | " + getNumberOfPages() + " | ";
    }
}