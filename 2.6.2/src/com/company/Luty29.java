package com.company;

import java.time.LocalDate;

public class Luty29 {
    protected LocalDate dataUrodzenia;

    public Luty29(String dataurodzenia) {
        this.dataUrodzenia = LocalDate.parse(dataurodzenia);
    }

    public int getWynik() {
        int wynik = 0;
        LocalDate dataObecna = LocalDate.now();
        LocalDate dataTymczasowa = getDataUrodzenia();
        if (getDataUrodzenia().isAfter(dataObecna))
            return 0;
        else {
            if (getDataUrodzenia().isLeapYear()) {
                if (getDataUrodzenia().isBefore(LocalDate.parse(getDataUrodzenia().getYear() + "-02-29")))
                    wynik++;
            }
            if (dataObecna.isLeapYear()) {
                if (dataObecna.isAfter(LocalDate.parse(dataObecna.getYear() + "-02-29")))
                    wynik++;
            }
            while (dataTymczasowa.isBefore(dataObecna)) {
                dataTymczasowa = LocalDate.of((dataTymczasowa.getYear() + 1), dataTymczasowa.getMonth(), dataTymczasowa.getDayOfMonth());
                if (dataTymczasowa.isLeapYear())
                    wynik++;
            }
        }
        return wynik;
    }

    public LocalDate getDataUrodzenia() {
        return dataUrodzenia;
    }
}