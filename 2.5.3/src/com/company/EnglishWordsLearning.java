package com.company;
import java.util.*;

public class EnglishWordsLearning {

    private WordsMap<String, Integer> words;
    private List<String> list;

    public  EnglishWordsLearning() {
        this.words = new WordsMap<>();
        EnglishWordsList englishWordsList = new EnglishWordsList();
        this.list = englishWordsList.getEnglishWordsList();
    }

    private String addNewWord(int day) {
        int size = list.size();
        int item = new Random().nextInt(size);
        int i = 0;
        for(String s : list) {
            if(i==item) {
                list.remove(s);
                words.put(s, Integer.valueOf(day));
                return s;
            }
            i++;
        }
        return  "";
    }

    private String forgetWords(int day) {
        String string = "";
        if(day>3) {
            List<String> wordsToForget = new ArrayList<>();
            int howManyWordsToForget = new Random().nextInt(3);
            if(howManyWordsToForget == 0) return "---";
            for(Map.Entry<String, Integer> e : words.entrySet()) {
                String key = e.getKey();
                Integer value = e.getValue();
                if(value <= day-3) wordsToForget.add(key);
            }
            for(int i=0; i<howManyWordsToForget; i++) {
                int size = wordsToForget.size();
                int item = new Random().nextInt(size);
                int j = 0;
                String tmp = "";
                for(String s : wordsToForget) {
                    if(j==item) {
                        tmp = s;
                        words.remove(s);
                        string = string + " " + s;
                    }
                    j++;
                }
                wordsToForget.remove(tmp);
            }
        }
        return string;
    }

    public void printLearing(int day) {
        for(int i=1; i<=day; i++) {
            System.out.println("Day " + i);
            System.out.println("New words: " + addNewWord(i) + ", " + addNewWord(i));
            if(i<=3) System.out.println("Forgotten words: ---" );
            else System.out.println("Forgotten words: " + forgetWords(i));
            System.out.println(words.toString());
        }
    }
}