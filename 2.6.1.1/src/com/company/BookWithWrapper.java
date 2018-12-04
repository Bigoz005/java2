package com.company;

public class BookWithWrapper extends BookDecorator{

    public BookWithWrapper(Publication decoratedBook) {
        super(decoratedBook);
        if(!decoratedBook.toString().contains("Okładka twarda")) {
            try {
                throw new NoHardCoverException();
            } catch (NoHardCoverException e) {
                System.out.println("Nie można obłożyć obwolutą książki, bez twardej okładkii!");
            }
            System.exit(0);
        }
        if(decoratedBook.toString().contains("Okładka z obwolutą")) {
            try {
                throw new NoMoreThanOneWrapperException();
            } catch (NoMoreThanOneWrapperException ne) {
                System.out.println("Obwoluta może być tylko jedna!");
            }
            System.exit(0);
        }
    }

    @Override
    public String toString() {
        return super.decoratedBook + " | " + "Okładka z obwolutą" + " | ";
    }
}