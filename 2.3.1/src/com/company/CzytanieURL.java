package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static java.nio.charset.StandardCharsets.UTF_8;

class CzytanieURL {

    static ArrayList<String> odczytNazwisk() {
        // odczyt z URL
        URL nazwiska = null;
        try {
            nazwiska = new URL("http://szgrabowski.kis.p.lodz.pl/zpo18/nazwiska.txt");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        BufferedReader in = null;

        try {
            in = new BufferedReader(new InputStreamReader(nazwiska.openStream(), UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String nazwisko;
        //Set zeby nie bylo powtorzen
        Set<String> setNazwiska = new HashSet<>();

        try {
            while ((nazwisko = in.readLine()) != null) {
                setNazwiska.add(nazwisko);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // skopiowanie nazwisk do ArrayList
        ArrayList<String> listNazwiska = new ArrayList<>(setNazwiska);

        return listNazwiska;
    }
}
