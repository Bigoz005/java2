package com.company;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MySplitter {
    public List<String> SplitString(@NotNull String s, int length) {
        if(length<0 || s == null) {
            throw new IllegalArgumentException();
        }

        List<String> output = new ArrayList<>();
        int currentLength = 0;

        if(s == "") output.add(s.substring(currentLength));
        while(currentLength<s.length()) {
            if(currentLength+length>s.length()) {
                output.add(s.substring(currentLength));
            } else output.add(s.substring(currentLength, currentLength + length));
            currentLength = currentLength + length;
        }
        return output;
    }
}
