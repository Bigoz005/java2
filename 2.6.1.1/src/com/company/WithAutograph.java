package com.company;

public class WithAutograph extends BookDekorator {

    private String Autograph;

    public String getAuthorAutograph() {
        return Autograph;
    }

    public void setAuthorAutograph(String Autograph2) {
        this.Autograph = Autograph2;
    }

    public WithAutograph(Publication decoratedBook, String authorAutograph) {
        super(decoratedBook);
        if(decoratedBook.getClass() == WithAutograph.class) {
            try {
                throw new NoMoreThanOneAuthorException("Tylko jeden autograf!");
            } catch (NoMoreThanOneAuthorException e) {
               System.out.println("Tylko jeden autograf");
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