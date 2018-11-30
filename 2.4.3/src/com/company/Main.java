package com.company;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<String> outputList = new ArrayList<>();
        MySplitter mySplitter = new MySplitter();
        outputList = mySplitter.SplitString("Ala ma kota", 4);
        String output = "";
        for (String s : outputList) {
            output += "\"" + s + "\" ";
        }
        System.out.println(output);
    }
}
