package com.company;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String args[]) {

        final String start = "1939-09-01";
        final int endYear = 1945;
        final int endMonth = 5;
        final int endDay = 8;
        final LocalDate endDate = LocalDate.of(endYear, endMonth, (endDay + 1));
        final int year2016 = 2016;
        final int month = 1;
        final int day = 1;
        final int liczbaDniDoDodania = 67;

        System.out.print("II wojna swiatowa trwala ");
        System.out.print(ChronoUnit.DAYS.between(
                LocalDate.parse(start), endDate));
        System.out.println(" dni");

        LocalDate rok2016 = LocalDate.of(year2016, month, day);
        LocalDate dzien68 = rok2016.plusDays(liczbaDniDoDodania);
        System.out.println(dzien68.getDayOfYear() + " dzien 2016 roku to " + dzien68.getDayOfMonth() + " " + dzien68.getMonth());

        Luty29 luty = new Luty29("1997-08-28");
        System.out.println("ilość 29 lutego: " + luty.getWynik());

    }
}