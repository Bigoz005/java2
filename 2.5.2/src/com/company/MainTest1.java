package com.company;

import java.util.HashMap;

import static org.junit.Assert.*;

public class MainTest1 {

    @org.junit.Test
    public void containsKey() {
        String key = "word";
        Integer value = 1;

        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        map1.merge(key, value, Integer::sum);
        Main.containsKey(map2, key, value);
        assertEquals(map1, map2);
    }

    @org.junit.Test
    public void get() {
        String key = "word";
        Integer value = 1;

        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        map1.merge(key, value, Integer::sum);
        Main.get(map2, key, value);
        assertEquals(map1, map2);
    }

    @org.junit.Test
    public void getOrDefault() {
        String key = "word";
        Integer value = 1;

        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        map1.merge(key, value, Integer::sum);
        Main.getOrDefault(map2, key, value);
        assertEquals(map1, map2);

    }

    @org.junit.Test
    public void pullIfAbsent() {
        String key = "word";
        Integer value = 1;

        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        map1.merge(key, value, Integer::sum);
        Main.pullIfAbsent(map2, key, value);
        assertEquals(map1, map2);
    }
}