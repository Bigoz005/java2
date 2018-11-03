package com.company;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

class Log {

    Logger logger;

    Log(String file_name) {
        File f = new File(file_name);
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            // false - nie bedzie dopisywal
            FileHandler fh = new FileHandler(file_name, false);
            // getLogger tworzy lub pobiera rejestrator
            logger = Logger.getLogger("");
            // dodanie uchwytu
            logger.addHandler(fh);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

