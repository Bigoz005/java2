package com.company;

public class BookDecorator implements Publication {
    protected Publication decoratedBook;

    public BookDecorator(Publication decoratedBook) {
        this.decoratedBook = decoratedBook;
    }

    @Override
    public String getBookAuthor() {
        return decoratedBook.getBookAuthor();
    }

    @Override
    public String getBookTitle() {
        return decoratedBook.getBookTitle();
    }

    @Override
    public int getNumberOfPages() {
        return decoratedBook.getNumberOfPages();
    }
}
