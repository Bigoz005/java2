package com.company;

public class BookDekorator implements Publication {
    protected Publication decoratedBook;

    public BookDekorator(Publication decoratedBook) {
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
