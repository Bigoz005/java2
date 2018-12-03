package com.company;

import java.util.HashMap;
import java.util.Map;

public class WordsMap<K, V> extends HashMap<K, V> {
    private static String SEPARATOR = ", ";

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(Map.Entry<K, V> entry : this.entrySet()) {
            sb.append(entry.getKey());
            sb.append(SEPARATOR);
        }
        sb.append("]");
        return sb.toString();
    }
}