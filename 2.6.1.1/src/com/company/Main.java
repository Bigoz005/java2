package com.company;

public class Main{
    public static void main(String[] args) {
        Publication b1 = new Book("Adam Mickiewicz", "Pan Tadeusz", 340);
        Publication b2 = new Book("Adam Mickiewicz", "Dziady", 130);

        Publication bb1 = new BookWithNormalCover(b1);
        Publication bb2 = new BookWithHardCover(b2);

        //Wyjątek - okładka może być tylko jedna!
        //Publication fail = new BookWithHardCover(bb1);

        //Wyjątek - nie można obłożyć obwolutą książki bez twardej okładki.
        //Publication fakeBook = new BookWithWrapper(bb1);

        Publication bbb2 = new BookWithWrapper(bb2);
        Publication test = new BookWithNormalCover(bbb2);

        //Wyjątek - obwoluta może być tylko jedna.
        //Publication reject = new BookWithWrapper(bbb2);

        Publication dziadyZAutografemWieszcza = new BookWithAuthorAutograph(bb2, "Drogiej Hani - Adam Mickiewicz");

        //Wyjątek - autograf może być tylko jeden.
        //Publication dziadyZDwomaAutografami = new BookWithAuthorAutograph(dziadyZAutografemWieszcza, "Haniu, to nieprawda, Dziady napisałem ja, Julek Słowacki!");

        System.out.println(b1.toString());
        System.out.println(b2.toString());
        System.out.println(bb1.toString());
        System.out.println(bb2.toString());
        System.out.println(bbb2.toString());
        System.out.println(dziadyZAutografemWieszcza.toString());
    }
}