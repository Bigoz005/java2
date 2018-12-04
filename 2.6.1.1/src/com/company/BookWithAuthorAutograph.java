package com.company;

public class BookWithAuthorAutograph extends BookDecorator {

    private String authorAutograph;

    public String getAuthorAutograph() {
        return authorAutograph;
    }

    public void setAuthorAutograph(String authorAutograph) {
        this.authorAutograph = authorAutograph;
    }

    public BookWithAuthorAutograph(Publication decoratedBook, String authorAutograph) {
        super(decoratedBook);
        if(decoratedBook.getClass() == BookWithAuthorAutograph.class) {
            try {
                throw new NoMoreThanOneAuthorException();
            } catch (NoMoreThanOneAuthorException e) {
                System.out.println("Autograf może być tylko jeden!");
                System.exit(0);
            }
        }
        setAuthorAutograph(authorAutograph);
    }

    @Override
    public String toString() {
        return super.decoratedBook + this.getAuthorAutograph() + " | ";
    }
}