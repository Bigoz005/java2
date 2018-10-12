package com.company;

import java.util.Scanner;

public class Convert {

    Convert(int liczba){
        konwersja(wybor(),liczba);
    }

    public String wybor(){
        Scanner odczyt = new Scanner(System.in);
        String system;
        do {
            System.out.println("Podaj w postaci tekstowej podstawę systemu na który ma być przekonwertowana liczba");
            system = odczyt.nextLine();
        }while(!system.equals("dziesiec") && !system.equals("trzy") && !system.equals("szesnascie"));
        return system;
    }

    public String konwersja(String podstawa, int liczba){
        switch (podstawa) {
            case "dziesiec":
                String wynik1 = Integer.toString(liczba);
                System.out.println(wynik1);
                break;
            case "trzy":
                String wynik2 = Integer.toString(liczba, 3);
                System.out.println(wynik2);
                break;
            case "szesnascie":
                String wynik3 = Integer.toString(liczba, 16);
                System.out.println(wynik3);
                break;
            default:
                break;
        }
        return podstawa;
    }
}
