package com.company;

public class Main{
    public static void main(String[] args) {
        Publication b1 = new Book("Mario Puzo", "Ojciec Chrzestny", 480);
        Publication b2 = new Book("Bruce Eckel", "Thinking In Java", 1200);

        Publication bb1 = new WithNormalCover(b1);
        Publication bb2 = new WithHardCover(b2);

        //Publication fail = new WithHardCover(bb1);

        //Publication fakeBook = new WithWrapper(bb1);

        Publication bbb2 = new WithWrapper(bb2);
        Publication test = new WithNormalCover(bbb2);

        //Publication reject = new WithWrapper(bbb2);

        Publication Salesman = new WithAutograph(bb2, "*Slaps cover of the book*");

        //Publication twoAutographs = new WithAuthorAutograph(Salesman, "This bad boy can fit so many crimes!");

        System.out.println(b1.toString());
        System.out.println(b2.toString());
        System.out.println(bb1.toString());
        System.out.println(bb2.toString());
        System.out.println(bbb2.toString());
        System.out.println(Salesman.toString());
        for( int i=0; i<3; i++){
            System.out.println();
        }
        Publisher p1 = PublisherFactory.getInstance("Józef Ignacy Kraszewski");
        Publisher p2 = PublisherFactory.getInstance("Katarzyna Bonda");
        Publisher p3 = PublisherFactory.getInstance("Henryk Sienkiewicz");

        Book b11 = p1.createBook("Masław", 280);
        Book b22 = p2.createBook("Okularnik", 354);
        Book b33 = p3.createBook("Potop", 722);
        Book b44 = p3.createBook("Krzyżacy", 1004);
        System.out.println(b11.toString());
        System.out.println(b22.toString());
        System.out.println(b33.toString());
        System.out.println(b44.toString());
    }
}
