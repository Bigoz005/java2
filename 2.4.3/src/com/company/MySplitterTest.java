package com.company;

import com.google.common.base.Splitter;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class MySplitterTest {
    private List<String> myOutputList;
    private List<String> guavaOutputList;
    private MySplitter mySplitter;
    private String myOutput;
    private String guavaOutput;

    @org.junit.Before
    public void setUp() throws Exception {
        this.myOutputList = new ArrayList<>();
        this.guavaOutputList = new ArrayList<>();
        this.mySplitter = new MySplitter();
        this.myOutput = "";
        this.guavaOutput = "";
    }

    @Test
    public void firstTest() {
        System.out.println("Test 1");
        String s = "Ala ma kota";
        int length = 4;
        System.out.println("String wejsciowy: \"" + s + "\", długość rozcięcia: " + length);

        guavaOutputList = Splitter.fixedLength(length).splitToList(s);
        for(String string : guavaOutputList) {
            guavaOutput += "\"" + string + "\" ";
        }
        System.out.println("Rozcięcie z użyciem biblioteki Guava: " + guavaOutput);

        myOutputList = mySplitter.SplitString(s, length);
        for(String string : myOutputList) {
            myOutput += "\"" + string + "\" ";
        }
        System.out.println("Rozcięcie z użyciem mojej metody: " + myOutput);
        System.out.println();

        assertEquals(guavaOutput, myOutput);
    }

    @Test
    public void secondTest() {
        System.out.println("Test 2");
        String s = "abcd";
        int length = 2;
        System.out.println("String wejsciowy: \"" + s + "\", długość rozcięcia: " + length);

        guavaOutputList = Splitter.fixedLength(length).splitToList(s);
        for(String string : guavaOutputList) {
            guavaOutput += "\"" + string + "\" ";
        }
        System.out.println("Rozcięcie z użyciem biblioteki Guava: " + guavaOutput);

        myOutputList = mySplitter.SplitString(s, length);
        for(String string : myOutputList) {
            myOutput += "\"" + string + "\" ";
        }
        System.out.println("Rozcięcie z użyciem mojej metody: " + myOutput);
        System.out.println();

        assertEquals(guavaOutput, myOutput);
    }

    @Test
    public void thirdTest() {
        System.out.println("Test 3");
        String s = "";
        int length = 3;
        System.out.println("String wejsciowy: \"" + s + "\", długość rozcięcia: " + length);

        guavaOutputList = Splitter.fixedLength(length).splitToList(s);
        for(String string : guavaOutputList) {
            guavaOutput += "\"" + string + "\" ";
        }
        System.out.println("Rozcięcie z użyciem biblioteki Guava: " + guavaOutput);

        myOutputList = mySplitter.SplitString(s, length);
        for(String string : myOutputList) {
            myOutput += "\"" + string + "\" ";
        }
        System.out.println("Rozcięcie z użyciem mojej metody: " + myOutput);
        System.out.println();

        assertEquals(guavaOutput, myOutput);
    }
}