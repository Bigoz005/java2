package com.company;

import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

    void zapis(String json, String imie, String nazwisko) {

        String nazwaPliku = imie + "_" + nazwisko + ".json";
        FileWriter fileWriter = null;

        try {
            try {
                fileWriter = new FileWriter(nazwaPliku);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                fileWriter.write(json);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

}