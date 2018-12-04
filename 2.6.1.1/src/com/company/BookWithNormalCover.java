package com.company;

public class BookWithNormalCover extends BookDecorator {

    public BookWithNormalCover(Publication decoratedBook) {
        super(decoratedBook);
        if ((decoratedBook.getClass() == BookWithNormalCover.class) || (decoratedBook.getClass() == BookWithHardCover.class)) {
            try {
                throw new NoMoreThanOneCover();
            } catch (NoMoreThanOneCover noMoreThanOneCover) {
                System.out.println("Okładka może być tylko jedna!");
                System.exit(0);
            }
        }
    }

    @Override
    public String toString() {
        return super.decoratedBook + " | " + "Okładka miękka" + " | ";
    }
}