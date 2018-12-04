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

        //Publication dziadyZDwomaAutografami = new WithAuthorAutograph(Salesman, "This bad boy can fit so many crimes!");

        System.out.println(b1.toString());
        System.out.println(b2.toString());
        System.out.println(bb1.toString());
        System.out.println(bb2.toString());
        System.out.println(bbb2.toString());
        System.out.println(Salesman.toString());
    }
}