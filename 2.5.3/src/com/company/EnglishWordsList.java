package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class EnglishWordsList {
    private List<String> englishWordsList;

    public List<String> getEnglishWordsList() {
        return englishWordsList;
    }

    public EnglishWordsList() {
        this.englishWordsList = new ArrayList<>();
        try {
            URL url = new URL("http://szgrabowski.iis.p.lodz.pl/zpo18/1500.txt");
            BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream()));

            String inputLine;
            while((inputLine = bf.readLine()) != null) {
                englishWordsList.add(inputLine);
            }
            bf.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}