package com.company;

public class Book implements Publication {
    private String bookAuthor;
    private String bookTitle;
    private String bookType;
    private int numberOfPages;

    public Book(){}

    public Book(String bookAuthor, String bookTitle, int numberOfPages) {
        this.bookAuthor = bookAuthor;
        this.bookTitle = bookTitle;
        this.numberOfPages = numberOfPages;
    }

    public String getBookType() {
        return this.bookType;
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