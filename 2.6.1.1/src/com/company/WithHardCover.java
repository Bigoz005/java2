package com.company;

public class WithHardCover extends BookDekorator {

    public WithHardCover(Publication decoratedBook) {
        super(decoratedBook);
        if((decoratedBook.getClass() == WithNormalCover.class) || (decoratedBook.getClass() == WithHardCover.class)) {
            try {
                throw new NoMoreThanOneCover("Tylko jedna okładka");
            } catch (NoMoreThanOneCover noMoreThanOneCover) {
                System.out.println("Tylko jedna okładka");
                System.exit(0);
            }
        }
    }

    @Override
    public String toString() {
        return super.decoratedBook + " | " + "Okładka twarda" + " | ";
    }
}